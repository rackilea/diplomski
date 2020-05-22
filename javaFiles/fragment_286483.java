public class MagicInjectionResolver implements InjectionResolver<MagicAnnotation> {

    @Inject @Named(InjectionResolver.SYSTEM_RESOLVER_NAME)
    private InjectionResolver<Inject> systemResolver;

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> handle) {
        if (injectee.getRequiredType() == MagicWrapper.class) {
            return systemResolver.resolve(injectee, handle);
        }
        return null;
    }

    @Override
    public boolean isConstructorParameterIndicator() { return false; }

    @Override
    public boolean isMethodParameterIndicator() { return true; }
}