public class SomeJerseyApplication extends ResourceConfig {

    public SomeJerseyApplication() {
        packages("you.packages.that.need.to.be.scanned.for.resources");
        register(SomeProvider.class);
        register(SomeJerseyFeature.class);
    }
}