import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, label = "Commons Activator")
public class Activator implements BundleActivator { 

@Reference
private SlingRepository repository;

private static final Logger logger = LoggerFactory.getLogger(Activator.class);

@Activate
@Override
public void start(BundleContext context) throws Exception {
    logger.info(context.getBundle().getSymbolicName() + " started");

    //My own factory class instance
    ResourceResolverDiscoveryService rrf = ResourceResolverDiscoveryService.getInstance();
    //Set the 'repository' in your factory class instance
    rrf.setSlingRepositoryFactory(repository);
}

@Deactivate
@Override
public void stop(BundleContext context) throws Exception {
    logger.info(context.getBundle().getSymbolicName() + " stopped");
}

}