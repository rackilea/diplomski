public class TenantDatastoreInjectionResolver 
        implements InjectionResolver<TenantDatastore> {

    @Inject
    @Named(InjectionResolver.SYSTEM_RESOLVER_NAME)
    InjectionResolver<Inject> systemInjectionResolver;

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> handle) {
        if (Datastore.class == injectee.getRequiredType()) {
            return systemInjectionResolver.resolve(injectee, handle);
        }
        return null;
    }

    @Override
    public boolean isConstructorParameterIndicator() { return false; }
    @Override
    public boolean isMethodParameterIndicator() { return false; }
}