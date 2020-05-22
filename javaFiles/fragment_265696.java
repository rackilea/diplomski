@Configuration
public class Example {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Example.class);
        System.out.println(ctx.getBean(DataSource.class));
    }
    @Bean(name = "mysql")
    public DataSource mysql() { return new MySQL(); }
    @Bean(name = "oracle")
    public DataSource oracle() { return new Oracle(); }
}
interface DataSource{}
class MySQL implements DataSource {}
class Oracle implements DataSource {}