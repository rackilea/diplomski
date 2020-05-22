public class StaticDelegateInterceptor extends EmptyInterceptor {

    private static Interceptor interceptor; 

    public static void setInterceptor(Interceptor interceptor) {
        StaticDelegate.interceptor = interceptor;
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
      return StaticDelegate.interceptor.onSave(entity, id, state, propertyNames, types);
    }
    ...
}