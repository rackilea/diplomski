@Configuration
public class OperatingSystemManagerFactory {

    @Bean
    public IOperatingSystemManager getOperatingSystemManager() {
        if ( /* some logic that evaluates to true if windows */ ) {
            return new WindowsManager();
        } else {
            // Linux default option ;)
            return new LinuxManager();
        }
    }
}