public class Container {
    private List<RuntimeBean> runtimeBeans = new ArrayList<RuntimeBean>();
    private RuntimeBeanFactory runtimeBeanFactory;

    public void load() {
        // repeated several times depending on external data/environment
        runtimeBeans.add(createRuntimeBean("Some external info1"));
        runtimeBeans.add(createRuntimeBean("Some external info2"));
    }

    public RuntimeBean createRuntimeBean(String info) {
         // should create bean which internally can have some 
         // spring annotations or in other words
         // should be managed by spring
         return runtimeBeanFactory.createRuntimeBean(info)
    }

    public void setRuntimeBeanFactory(RuntimeBeanFactory runtimeBeanFactory) {
        this.runtimeBeanFactory = runtimeBeanFactory
    }
}

public interface RuntimeBeanFactory {
    RuntimeBean createRuntimeBean(String info);
}

//and finally
@Configuration
public class ApplicationConfiguration {

    @Bean
    Container container() {
        Container container = new Container(beanToInject());
        container.setBeanRuntimeFactory(runtimeBeanFactory());
        return container;
    }

    // LOOK HOW IT IS SIMPLE IN THE JAVA CONFIGURATION
    @Bean 
    public BeanRuntimeFactory runtimeBeanFactory() {
        return new BeanRuntimeFactory() {
            public RuntimeBean createRuntimeBean(String beanName) {
                return runtimeBean(beanName);
            }
        };
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    RuntimeBean runtimeBean(String beanName) {
        return new RuntimeBean(beanName);
    }
}

class RuntimeBean {
    @Autowired
    Container container;
}