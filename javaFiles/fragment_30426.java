@Configuration
public class Config1 {
    @Bean public Greeter british(){ return () -> "Hi"; }
    @Bean public Greeter obiWan(){ return () -> "Hello there"; }
    @Bean public Greeter american(){ return () -> "Howdy"; }
}