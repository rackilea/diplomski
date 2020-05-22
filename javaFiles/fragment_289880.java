public class CurrentUserInjectionResolver implements InjectionResolver<CurrentUser> {

    javax.inject.Provider<ContainerRequestContext> requestContext;

    @Inject
    public CurrentUserInjectionResolver(
        javax.inject.Provider<ContainerRequestContext> requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> sh) {
        if (User.class == injectee.getRequiredType()) {
            return requestContext.get().getProperty(UserFilter.USER_PROP);
        }
        return null;
    }

    @Override
    public boolean isConstructorParameterIndicator() { return false; }

    @Override
    public boolean isMethodParameterIndicator() { return false; }
}