public class ConfigurationInjectionResolver implements InjectionResolver<Named> {  
    @Context
    Application application;

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> root) {
        Named annotation = injectee.getParent().getAnnotation(Named.class);
        Map<String, Object> props = application.getProperties();
        String name = annotation.value();
        System.out.println(props.get(name));
        return props.get(name);
    }

    @Override
    public boolean isConstructorParameterIndicator() { return false; }
    @Override
    public boolean isMethodParameterIndicator() { return false; }  
}

@ApplicationPath("/rest")
public class JerseyApplication extends ResourceConfig {

    public JerseyApplication() {
        packages("jersey.startup.test");
        property("hello.config", "Hello World Property");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(ConfigurationInjectionResolver.class)
                        .to(new TypeLiteral<InjectionResolver<Named>>() {
                        }).in(Singleton.class);
            }
        });
    }
}