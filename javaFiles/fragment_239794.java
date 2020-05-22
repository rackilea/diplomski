private <T> T invokeWrappedFunction(Object instance, String methodName, Object... args) {
    Class[] classes = null;
    if (args != null) {
        classes = new Class[args.length];
        for (int i = 0; i < args.length; ++i) {
            classes[i] = args[i].getClass();
        }
    }

    try {
        Method m = instance.getClass().getMethod(methodName, classes);
        return (T) m.invoke(instance, args);
    } catch(Exception e) {
        //This is an example, you're lucky I even acknowledged the exception!
    }
}