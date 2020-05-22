public class PathInterceptionService implements InterceptionService {

    private static final ConstructorInterceptor CTOR_INTERCEPTOR
            = new LoggingConstructorInterceptor();
    private final static List<ConstructorInterceptor> CTOR_LIST
            = Collections.singletonList(CTOR_INTERCEPTOR);

    @Override
    public Filter getDescriptorFilter() {
        return BuilderHelper.allFilter();
    }

    @Override
    public List<MethodInterceptor> getMethodInterceptors(Method method) {
        return null;
    }

    @Override
    public List<ConstructorInterceptor> getConstructorInterceptors(Constructor<?> ctor) {
        if (ctor.getDeclaringClass().isAnnotationPresent(Path.class)) {
            return CTOR_LIST;
        }
        return null;
    }
}