@Configuration
class Config {
    @Bean
    public A a() {
        A a = new A();
        return a;
    }

    @Bean
    public B b() {
        B b = new B();
        A a = a();
        b.setA(a);
        a.setB(b);
        return b;
    }
}