@ApplicationPath("/rest")
public class JerseyApplication extends ResourceConfig {

    @Inject
    public JerseyApplication(ServiceLocator locator) {
        packages("jersey.startup.test");
        ServiceLocatorUtilities.addClasses(locator, ConfigResource.class);
        try {
            loadConfigurationProperties(locator);
        } catch (IOException ex) {
            Logger.getLogger(JerseyApplication.class.getName())
                                   .log(Level.SEVERE, null, ex);
        }
    }

    private void loadConfigurationProperties(ServiceLocator locator) 
                                                 throws IOException {
        ConfigurationUtilities.enableConfigurationSystem(locator);
        PropertyFileUtilities.enablePropertyFileService(locator);
        PropertyFileService propertyFileService 
                = locator.getService(PropertyFileService.class);
        Properties props = new Properties();
        URL url = getClass().getResource("/configuration.properties");
        props.load(url.openStream());
        PropertyFileHandle propertyFileHandle 
                = propertyFileService.createPropertyHandleOfAnyType();
        propertyFileHandle.readProperties(props);
    }
}