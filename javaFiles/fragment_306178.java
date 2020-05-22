import org.glassfish.hk2.api.PerLookup;

@Provider
public class ProjectFeature implements Feature {

  @Override
  public boolean configure(FeatureContext context) {

    context.register(new AbstractBinder() {
      @Override
      protected void configure() {
      bindFactory(ProjectFactory.class)
          .to(Project.class)
          .proxy(false)
          .proxyForSameScope(true)
          .in(PerLookup.class);
    });

    return true;
  }

}