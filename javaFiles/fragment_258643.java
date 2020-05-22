// pass "null" for parIdentifiers and parameters if it's a method without any
public static void invokeMethod(String className, String methodName, 
                       Class<?>[] parIdentifiers, Object[] parameters) {
    try {

        // Your code
        Class<?> commandclass = Class.forName(className);
        Method method = commandclass.getMethod(methodName, parIdentifiers);
        method.invoke(method, parameters); 

    } catch (NoSuchMethodException | SecurityException | ClassNotFoundException 
           | IllegalAccessException | IllegalArgumentException 
           | InvocationTargetException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    Class<?>[] types = new Class<?>[]{String.class, String.class};
    Object[] params = new Object[]{"param1", "param2"};
    invokeMethod("foo.Class", "method", types, params);
}