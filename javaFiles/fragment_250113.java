@SpringBootApplication
@ComponentScan({"com.XYZ.microservices.core"})
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}