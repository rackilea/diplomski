Map<?, ?> map = (Map<?, ?>) target;
Object value = map.get(name);
if (value == null && !map.containsKey(name)) {
    throw new MapAccessException(name);
}
return new TypedValue(value);