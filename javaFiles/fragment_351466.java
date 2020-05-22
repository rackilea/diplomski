@Configuration
public class SomeScopedBeanFactoryConfiguration {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SomeScopedBean create(Properties configuration) {
        return new SomeScopedBean(configuration);
    }

}