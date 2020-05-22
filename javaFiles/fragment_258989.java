@ApplicationScoped
public class LoginProviderFactory {

    @Produces
    @LoginProviderProducer
    public LoginProvider createLoginProvider(@Any Instance<LoginProvider> instance, InjectionPoint injectionPoint) {
        Annotated annotated = injectionPoint.getAnnotated();
        LoginProviderType loginProviderTypeAnnotation = annotated.getAnnotation(LoginProviderType.class);
        Class<? extends LoginProvider> loginProviderType = loginProviderTypeAnnotation.value().getLoginProviderType();
        //return instance.select(loginProviderType).get();
        if (loginProviderType == LoginProvider1Impl.class) {
            return new LoginProvider1Impl();
        } else if (loginProviderType == LoginProvider2Impl.class) {
            return new LoginProvider2Impl();
        } else
            return null;
    }
}