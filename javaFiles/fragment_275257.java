public class MyResourceConfig extends ResourceConfig {

    public MyResourceConfig(Class... classes) {
        super(classes);
        register(new SSOAuthorizationResolver.Binder());
    }
}