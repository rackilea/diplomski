try {
    // retrieving class
    Class<?> c = Class.forName(str);

    // will throw IllegalAccessException if the class
    // or its nullary constructor is not accessible:
    Object t = c.newInstance();

    Method[] allMethods = c.getDeclaredMethods();
    for (Method m : allMethods) {
        String mname = m.getName();

        // run only test methods
        if (!mname.startsWith("test")) {
            continue;
        }

        Type[] pType = m.getGenericParameterTypes();
        if (pType.length != 0) {
            throw new RuntimeException("Test methods must not have parameters.");
        }

        try {
            // you can call private methods by setting this flag
            m.setAccessible(true);

            // invoking method m of instance t
            m.invoke(t);

        } catch (InvocationTargetException x) {
            // Handle any exceptions thrown by method to be invoked.
            Throwable cause = x.getCause();
            err.format("invocation of %s failed: %s%n",
               mname, cause.getMessage());
        }
    }

    // production code should handle these exceptions more gracefully
} catch (ClassNotFoundException x) {
    x.printStackTrace();
} catch (InstantiationException x) {
    x.printStackTrace();
} catch (IllegalAccessException x) {
    x.printStackTrace();
}