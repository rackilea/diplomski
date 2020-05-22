Class<?> aClass = object.getClass();
try {
    Method method = aClass.getMethod("methodName", argType1, argType2);
    method.invoke(arg1, arg2)
} catch (NoSuchMethodException | SecurityException e) {
    e.printStackTrace();
}