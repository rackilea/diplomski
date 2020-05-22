@Configuration
public class FelineConfig implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (Feline feline : Feline.values()) {
            String beanName = Feline.class.getName() + "." + feline.name();
            beanFactory.registerSingleton(beanName, feline);
        }
    }

}