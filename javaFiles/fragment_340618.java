@SuppressWarnings("unchecked")
public <T> T getObjectWithSelectedFields(T sourceObject, Collection<String> fields)
    throws InstantiationException, IllegalAccessException {
  Class<?> clazz = sourceObject.getClass();
  Object targetObject = clazz.newInstance();

  Arrays.stream(clazz.getDeclaredFields()).filter(f -> fields.contains(f.getName())).forEach(f -> {
    try {
      f.set(targetObject, f.get(sourceObject));
    } catch (IllegalArgumentException | IllegalAccessException e) {
      // TODO ...
    }
  });

  return (T)targetObject;
 }