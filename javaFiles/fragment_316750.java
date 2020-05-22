@SpringBootApplication
public class BootvavrApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootvavrApplication.class, args);
    }

    @Bean
    Module vavrModule() {
        return new VavrModule();
    }
}