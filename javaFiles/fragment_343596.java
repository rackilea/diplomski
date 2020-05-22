@Autowired
@Tags({"greeting", "other"})
private Map<String, Supplier<String>> greetingOrOther;

@Configuration
static class Beans {
   @Tags({"greeting", "2symbols", "even"})
   @Bean
   public Supplier<String> hi() {
      return () -> "hi";
   }

   @Tags({"parting", "2symbols", "even"})
   @Bean
   public Supplier<String> by() {
      return () -> "by";
   }

   @Tags({"greeting", "5symbols", "odd"})
   @Bean
   public Supplier<String> hello() {
      return () -> "hello";
   }

   @Tags({"parting", "7symbols", "odd"})
   @Bean
   public Supplier<String> goodbye() {
      return () -> "goodbye";
   }

   @Tags({"other", "5symbols", "odd"})
   @Bean
   public Supplier<String> other() {
      return () -> "other";
   }
}