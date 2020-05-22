public class HealthEndpoint {

  private static final Logger LOGGER = LoggerFactory.getLogger(HealthEndpoint.class);

  @Context
  private ServletContext context;

  private BuildInfo buildInfo;

  @GET
  public BuildInfo getBuildInfo() {
    LOGGER.debug("Build info has been requested");
    setBuildInfo();
    return buildInfo;
  }

  private void setBuildInfo() {
    if (buildInfo != null) {
        return;
    }
    // some logic of setting build info with help of manifest file here
  }
}