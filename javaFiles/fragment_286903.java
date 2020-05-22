public class ClassToInvoke {
    public void someMethod() {};
}

public class ClassA implements InterfaceA {

    @Override
    public void run() {
        // do something
    }
}

public class ClassToInvoke {
    public void someMethod() {};
}

public class MethodInvoker {

    public Boolean invoke(Method method, Object obj, InterfaceA a) throws Exception {
         return (Boolean) method.invoke(obj, a);
    }
}

public class MethodStore {

    Map<Class<?>, Method> map = new HashMap<Class<?>, Method>();

    public Method getMethod(InterfaceA obj) {
        return map.get(obj);
    }
}