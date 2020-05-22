@ComponentScan({"com.bonanza.web","com.bonanza.backend.service"})
@SpringBootApplication
public class BonanzaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BonanzaWebApplication.class, args);
    }

}