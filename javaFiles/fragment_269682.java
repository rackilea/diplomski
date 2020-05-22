@Configuration
public class MyConfig {
    @Value("${A.v}")
    private String av;

    @Value("${B.v}")
    private String bv;

    @Bean
    public A a() {
       A a = new A();
       a.setV(av);
    }


    @Bean
    public B b() {
       B b = new B();
       b.setV(bv);
    }
}