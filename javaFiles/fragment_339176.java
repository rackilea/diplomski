@Configuration
@AnnotationDrivenConfig
@ImportXml("classpath:applicationContext.xml")
public class Config {

    @Autowired
    private ApplicationContext context;

    @Bean(name = "fooRepository")
    @Scope("prototype")
    public FooRepository fooRepository() {
        return new JdbcFooRepository(context.getBean("foo", Foo.class));
    }
}