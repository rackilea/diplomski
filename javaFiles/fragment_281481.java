@SpringBootApplication
 @Configuration
 public class DemoApplication {
     @Bean
     public SimpleModule addDeser() {
         return new SimpleModule().addDeserializer(Boolean.class, new MyDeser());
     }
     public static void main(String[] args) {
         SpringApplication.run(DemoApplication.class, args);
     }
 }