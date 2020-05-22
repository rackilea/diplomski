public class ReferenceListener {

private Logger log; // set this up
private BundleContext bundleContext;

public void setBundleContext(BundleContext bundleContext) {
    this.bundleContext = bundleContext;
}

// Called when the service is injected
public void bind(ServiceReference<?> sr) {
    log.info("Bind of ServiceReference {} to bundle {}",
            sr, bundleContext.getBundle());
}

// Called when the service is removed
public void unbind(ServiceReference<?> sr) {
    log.info("Unbind of ServiceReference {} from bundle {}",
            sr, bundleContext.getBundle());
    try {
        if (bundleContext.getBundle().getState() == Bundle.ACTIVE) {
            log.warn("Bundle {} will be stopped after unbind of mandatory ServiceReference {}",
                    bundleContext.getBundle(), sr);
            bundleContext.getBundle().stop();
        }

    } catch (BundleException e) {
        log.error("Cannot stop bundle {} after unbind of ServiceReference {}",
                bundleContext.getBundle().getBundleId(),
                sr,
                e);
    }
}
}