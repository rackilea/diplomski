import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class ExcludeAutowiredBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ConfigurableListableBeanFactory configurableBeanFactory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            ExcludeBeanByQualifierForCollectionAutowired myAutowiredExcludeAnnotation = field.getAnnotation(ExcludeBeanByQualifierForCollectionAutowired.class);
            if (myAutowiredExcludeAnnotation != null) {

                Collection<Object> beanForInjection = new ArrayList<>();

                String[] beanNamesOfType = configurableBeanFactory.getBeanNamesForType(myAutowiredExcludeAnnotation.aClass());
                for (String injectedCandidateBeanName : beanNamesOfType) {

                    Object beanCandidate = configurableBeanFactory.getBean(injectedCandidateBeanName);

                    Qualifier qualifierForBeanCandidate = beanCandidate.getClass().getDeclaredAnnotation(Qualifier.class);

                    if (qualifierForBeanCandidate == null || !qualifierForBeanCandidate.value().equals(myAutowiredExcludeAnnotation.qualifierToExcludeValue())) {
                        beanForInjection.add(beanCandidate);
                    }
                }
                try {
                    field.set(bean, beanForInjection);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}