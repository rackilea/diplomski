@Provider
public class UserFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        context.register(new AbstractBinder(){
            @Override
            public void configure() {

                bind(CurrentUserInjectionResolver.class)
                .to(new TypeLiteral<InjectionResolver<CurrentUser>>(){})
                        .in(Singleton.class);
            }
        });
        return true;          
    } 
}