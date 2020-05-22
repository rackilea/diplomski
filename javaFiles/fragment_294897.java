import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
...

@ApplicationPath("/rest")
public class JerseyApplication extends ResourceConfig {

    @Inject
    public JerseyApplication(ServiceLocator locator) {
        ServiceLocatorUtilities.enableImmediateScope(locator);
        packages("thepackages.to.scan");
    }
}