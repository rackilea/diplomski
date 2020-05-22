@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.springmvcproject.concertio"})
public class FrontController implements WebMvcConfigurer {
     @Bean(name="messageSource")
    public MessageSource getMessageSource() { .....  }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {....}

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { .... }

   @Bean
    InternalResourceViewResolver viewResolver(){ .... }
}