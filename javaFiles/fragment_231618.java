private static String[] initMethods = {
        "setName", "setStreet", "setNumberAsString"
};

private static Method getMethod(int index) throws NoSuchMethodException {
    if ((index < 0) || (index > initMethods.length - 1)) return null;
    Class clazz = MyObjectImpl.class;
    return clazz.getMethod(initMethods[index], String.class);
}

public static MyObjectImpl retrieveWithValues(String[] values) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    if (values.length != initMethods.length) return null;   // Handle the fact you don't have the same amount of initialisations as the amount of fields
    MyObjectImpl o = new MyObjectImpl();
    for (int i = 0; i < initMethods.length; i++) {
        Method m = getMethod(i);
        m.invoke(o, values[i]);
    }
    return o;
}