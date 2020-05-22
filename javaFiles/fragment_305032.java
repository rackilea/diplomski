for (Field f : obj.getClass().getFields()) {
  f.setAccessible(true);
  if (f.get(obj) == null) {
     f.set(obj, getDefaultValueForType(f.getType()));
  }
}