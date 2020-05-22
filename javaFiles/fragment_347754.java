Map<Class<?>, Function<Object, String>> map;

Function<Object, String> converter;
do {
     converter = map.get(clazz);
     clazz = clazz.getSuperclass();
} while (converter == null && clazz != null;

String asText = converter == null
    ? String.valueOf(value)
    : converter.apply(value);