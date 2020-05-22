@Component(label = ScrRunner.COMPONENT_LABEL, description = ScrRunner.COMPONENT_DESCRIPTION, immediate = true, metatype = true)
@Properties({
    @Property(name = "camelContextId", value = "scr-runner"),
    @Property(name = "camelRouteId", value = "scr-file-router"),
    @Property(name = "active", value = "true"),
})
@References({
    @Reference(name = "camelComponent",referenceInterface = ComponentResolver.class,
        cardinality = ReferenceCardinality.MANDATORY_MULTIPLE, policy = ReferencePolicy.DYNAMIC,
        policyOption = ReferencePolicyOption.GREEDY, bind = "gotCamelComponent", unbind = "lostCamelComponent")
})
public class ScrRunner extends AbstractCamelRunner {

    public static final String COMPONENT_LABEL = "ScrRunner";
    public static final String COMPONENT_DESCRIPTION = "This is the description for ScrRunner";

    @Override
    protected List<RoutesBuilder> getRouteBuilders() {
        List<RoutesBuilder> routesBuilders = new ArrayList<>();
        routesBuilders.add(new ScrFileRouter());
        return routesBuilders;
    }

    @Override
    protected void setupCamelContext(BundleContext bundleContext, String camelContextId)throws Exception{
        super.setupCamelContext(bundleContext, camelContextId);

        // Use MDC logging
        getContext().setUseMDCLogging(true);

        // Use breadcrumb logging
        getContext().setUseBreadcrumb(true);
    }
}