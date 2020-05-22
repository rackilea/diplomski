@Configuration
public class BeanConfiguration {

    @Bean
    public Bean1Included getBean1(){
        return new Bean1Included();
    }

    @Bean
    public Bean2Included getBean2(){
        return new Bean2Included();
    }

    @Bean
    public Bean3Included getBean3(){
        return new Bean3Included();
    }

    @Bean
    public BeanExcluded getExcludedBean(){
        return new BeanExcluded();
    }

    @Bean
    public ExcludeAutowiredBeanPostProcessor excludeAutowiredBeanPostProcessor(){
        return new ExcludeAutowiredBeanPostProcessor();
    }
}