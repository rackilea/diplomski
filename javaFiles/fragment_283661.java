public class AuthInterceptor implements ResolverInterceptor {

    @Override
    public Object aroundInvoke(InvocationContext context, Continuation continuation) throws Exception {
        Auth auth = context.getResolver().getExecutable().getDelegate().getAnnotation(Auth.class);
        User currentUser = context.getResolutionEnvironment().dataFetchingEnvironment.getContext();
        if (auth != null && !currentUser.getRoles().containsAll(Arrays.asList(auth.rolesRequired()))) {
            throw new IllegalAccessException("Access denied"); // or return null
            }
        return continuation.proceed(context);
    }
}