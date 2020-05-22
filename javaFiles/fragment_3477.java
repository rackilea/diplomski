Class aClass = f.getClass();
Class[] paramTypes = new Class[1];
paramTypes[0] = String.class; // get the actual param type

String methodName = "set" + fieldName; // fieldName String
Method m = null;
try {
    m = aClass.getMethod(methodName, paramTypes);
} catch (NoSuchMethodException nsme) {
    nsme.printStackTrace();
}

try {
    String result = (String) m.invoke(f, fieldValue); // field value
    System.out.println(result);
} catch (IllegalAccessException iae) {
    iae.printStackTrace();
} catch (InvocationTargetException ite) {
    ite.printStackTrace();
}