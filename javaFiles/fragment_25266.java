public class EnvironmentPropertyInitializer implements 
                   ApplicationContextInitializer<ConfigurableApplicationContext> {

    boolean override = false; //change if you prefer envionment over command line args

    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        for (Entry<String, String> environmentProp : System.getenv().entrySet()) {
            String key = environmentProp.getKey();
            if (override || System.getProperty(key) == null) {
                System.setProperty(key, environmentProp.getValue());
            }
        }
    }
}