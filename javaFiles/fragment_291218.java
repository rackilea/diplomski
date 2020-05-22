public class User {

    public void methodToBeCalledUsingReflection() {
        // some logic
    }

    public void invocationWithPerformanceHit() {
        // lookup of Method instance - costly operation!
        Method method = User.class.getMethod("methodToBeCalledUsingReflection");
        // actual invocation of method
        method.invoke(this);
    }

    public void invocationWithoutPerformanceHit() {
        // only actual invocation of method
        method.invoke(this);
    }

    // moving Method instance to static field which is initialized (looked up) only once
    public static final Method method = getMethodReference("methodToBeCalledUsingReflection");

    private static Method getMethodReference(String methodName) {
        try {
            return User.class.getMethod(methodName);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}