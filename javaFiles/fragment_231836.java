Field field = c.getDeclaredField(fieldName);
field.setAccessible(true);

@SuppressWarnings(value="unchecked")
T t = (T) field.get(obj);

return t;