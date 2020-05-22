public class MyInvocationHandler implements InvocationHandler {

        private Object obj;

        MyInvocationHandler (Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, final Method method, final Object[] args) throws Throwable {
            boolean isNotNull = method.isAnnotationPresent(NotNull.class);

            if (isNotNull) {
    /* process annotated method. Or go through proxy object fields etc.. */

            }
        }
}