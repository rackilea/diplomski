@SuppressWarnings("unchecked")
public <T> T getParameter(String key, Class<T> clazz) {
    Object o = parameters.get(key)
    if(clazz.isInstance(o)) {
        return (T) o;
    } else {
        return null; // or something better...
    }
}