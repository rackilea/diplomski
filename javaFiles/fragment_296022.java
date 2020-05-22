public static Object parseDynamic(String type, byte[] bytes) {
    try {
        Class<?> clazz = Class.forName(type);
        Method method = clazz.getDeclaredMethod("parseFrom", byte[].class);
        return method.invoke(null, bytes);
    } catch (NoSuchMethodException e) {
        throw new IllegalArgumentException("Non-message type", e);
    } catch (IllegalAccessException e) {
        throw new IllegalArgumentException("Non-message type", e);
    } catch (InvocationTargetException e) {
        // TODO: Work out what exactly you want to do.
        throw new IllegalArgumentException("Bad data?", e);
    }
}