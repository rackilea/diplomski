try {
    Class<?> clazz = Class.forName(packagePrefix + "." + functionName);
    Object instance = clazz.newInstance();
    if (instance instanceof DifferentiableFunction) {
        //...
    } else if (instance instanceof Function) {
        //...
    }
} catch (ClassNotFoundException ex) {
    ex.printStackTrace();
} catch (InstantiationException ex) {
    ex.printStackTrace();
} catch (IllegalAccessException ex) {
    ex.printStackTrace();
}