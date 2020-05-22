@SpringBootApplication
@ImportResource("classpath:config.xml")
public class App {
    public App(PropertiesFactoryBean multipleWriterLocations) throws IOException {
        // Access the Properties populated from writerLocations.properties
        Properties properties = multipleWriterLocations.getObject();
        System.out.println(properties);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}