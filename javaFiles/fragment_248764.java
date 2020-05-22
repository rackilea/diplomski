@Configuration
@EnableAutoConfiguration
@ImportResource("classpath:ApplicationContextServer.xml")
public class SpringServerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Object[] {SpringServerApplication.class}, args);
    }
}