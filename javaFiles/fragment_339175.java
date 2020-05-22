@Configuration
@AnnotationDrivenConfig
@ImportXml("classpath:applicationContext.xml")
public class Config {

    @Bean(name = "fooRepository")
    @Scope("prototype")
    public FooRepository fooRepository() {
        return new JdbcFooRepository(foo());
    }

    @Bean(name = "foo")
    @Scope("prototype")
    public Foo foo() {
        return new foo();
    }
}