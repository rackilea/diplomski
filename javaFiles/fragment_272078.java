@SpringBootApplication
@EnableAsync
public class DemoApplication {

@Autowired
AsyncService asyncService;

    public someMethod() {
        SpringApplication.run(DemoApplication.class, args);
        asyncService.asyncMethod();
        asyncService.asyncMethod();
    }

}