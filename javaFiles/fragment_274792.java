@Override
public <T> T convertValue(Object object, Class<T> clazz) {
    if (clazz == String.class) {
        return (T) "a";
    }
    else {
        throw new IllegalArgumentException("I only support String, sorry");
    }
}