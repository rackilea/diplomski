public abstract class FacadeBase<T extends FacadeException> {

    private final Class<T> genericClazz;
    public FacadeBase () {
        this.genericClazz = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), FacadeBase.class);    
    }
}