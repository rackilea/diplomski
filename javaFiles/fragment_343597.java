@Configuration
public class AutowireConfig {
   @Bean
   public CustomAutowireConfigurer autowireConfigurer(DefaultListableBeanFactory beanFactory) {
      CustomAutowireConfigurer configurer = new CustomAutowireConfigurer();
      beanFactory.setAutowireCandidateResolver(new TaggedAutowireCandidateResolver());
      configurer.postProcessBeanFactory(beanFactory);
      return configurer;
   }
}