@Configuration
public class AppConfig {
    //similar to @Produces CDI annotation
    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl();
    }
}