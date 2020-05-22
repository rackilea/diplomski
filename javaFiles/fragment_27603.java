protected Class<?> findClass(String name) throws ClassNotFoundException {
  byte[] bytes = map.get(name);
  if (bytes != null) {
    return defineClass(name, bytes, 0, bytes.length);
  } else {
    throw new ClassNotFoundException(name);
  }
}