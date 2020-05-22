HttpMediaTypeNotAcceptableException or 406 means we have problems with Content Negotiation. By default spring will first check with the path extension. 
In your case, your endpoint have suffix with .pdf, so it is expecting as application.pdf or pdf is required but your end point defined something else. So it gives 406 error. you can check more details here
<https://spring.io/blog/2013/05/11/content-negotiation-using-spring-mvc>

To resolve the issue you can easily change this configuration using ContentNegotiationConfigurer accessed by extending WebMvcConfigurerAdapter. 



 @Configuration
    @EnableWebMvc
    public class WebConfig extends WebMvcConfigurerAdapter {

      @Override
      public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
      }
    }