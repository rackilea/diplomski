public YourProxy implements InvocationHandler {
public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {
    if (method.isAnnotationPresent(ValidateNull.class)) {
                   //Check args if they are null and return.
            }
     }
 }