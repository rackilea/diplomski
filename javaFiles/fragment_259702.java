// Put in Reflector.java

/**
 * Changes the annotation value for the given key of the given annotation to newValue and returns
 * the previous value.
 */
@SuppressWarnings("unchecked")
public static Object changeAnnotationValue(Annotation annotation, String key, Object newValue){
    Object handler = Proxy.getInvocationHandler(annotation);
    Field f;
    try {
        f = handler.getClass().getDeclaredField("memberValues");
    } catch (NoSuchFieldException | SecurityException e) {
        throw new IllegalStateException(e);
    }
    f.setAccessible(true);
    Map<String, Object> memberValues;
    try {
        memberValues = (Map<String, Object>) f.get(handler);
    } catch (IllegalArgumentException | IllegalAccessException e) {
        throw new IllegalStateException(e);
    }
    Object oldValue = memberValues.get(key);
    if (oldValue == null || oldValue.getClass() != newValue.getClass()) {
        throw new IllegalArgumentException();
    }
    memberValues.put(key,newValue);
    return oldValue;
}