@SpringBootApplication
public class DemoApplication implements ApplicationRunner
{

    @Value("${person.name}")
    private String name;

    public static void main( String[] args )
    {
        SpringApplication.run( DemoApplication.class, args );
    }

    @Override
    public void run( ApplicationArguments args ) throws Exception
    {
        System.out.println( "Name: " + name );
    }
}