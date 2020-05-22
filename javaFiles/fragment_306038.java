Map<String,Object> parameters;

...

@SuppressWarnings("unchecked")
public <T> T getParameter(String key, Class<T> clazz) {
    return (T) parameters.get(key);
}