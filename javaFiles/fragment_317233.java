//Loading the class at runtime
public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
    Class<?> someInterface = Class.forName("SomeInterface");

    Object instance = Proxy.newProxyInstance(someInterface.getClassLoader(), new Class<?>[]{someInterface}, new InvocationHandler() {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            //Handle the invocations
            if(method.getName().equals("someMethod")){
                return 1;
            }
            else return -1;
        }
    }); 
    System.out.println(instance.getClass().getDeclaredMethod("someMethod", (Class<?>[])null).invoke(instance, new Object[]{}));
}