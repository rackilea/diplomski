@Component
public class GetSubtypesOfClass implements ApplicationContextAware {

@Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        List<Subtype> matches = new ArrayList<>();
        for (String s : ac.getBeanDefinitionNames()) {
            Object bean = ac.getBean(s);
            if (Subtype.class.isAssignableFrom(bean.getClass())) {
                matches.add(bean);
            }
        }
    }
}