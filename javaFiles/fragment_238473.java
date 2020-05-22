@SpringBootApplication
public class DemoApplication {

  @Component
  public static class TextJavascriptConverter extends AbstractJackson2HttpMessageConverter {
    public TextJavascriptConverter() {
      //can use overloaded constructor to set supported MediaType
      super(new ObjectMapper(), new MediaType("text", "javascript"));
    }
  }

  @Bean
  public ApplicationRunner demoRunner(RestTemplateBuilder builder, TextJavascriptConverter javascriptConverter) {
    return args -> {
      //can autowire RestTemplateBuilder for sensible defaults (including converters)
      RestTemplate restTemplate = builder.build();

      //confirm your converter is there
      if (restTemplate.getMessageConverters().contains(javascriptConverter)) {
        System.out.println("My custom HttpMessageConverter was registered!");
      }
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}