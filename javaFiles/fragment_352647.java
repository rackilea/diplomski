@SpringBootApplication
@EnableConfigServer
public class Application
{
    public static void main(String[] args)
    {
        System.setProperty("javax.net.ssl.trustStore",
            Application.class.getResource("/configTrustStore.jks").getFile());
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        SpringApplication.run(Application.class, args);
    }
}