@Configuration
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new String[] {
                "classpath*:web/config/viewResolver.xml",
            }, args);
}
}