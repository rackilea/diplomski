@Configuration 
public class Config {

    @Bean
    public FooUser fooUser() {
        return new FooUser(foo());
    }

    @Bean
    public FooFactory fooFactory() {
        return new FooFactory();
    }

    @Bean
    public Foo foo() {
        return fooFactory().createFoo();
    }

}