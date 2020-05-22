if (instance != null) {
  try (InputStream stream = new FileInputStream(file)) {
    instance = getInstance(stream);
    instance.sourceFile = file;
    instances.put(instance.sourceFile.getPath(), instance);
    return instance;
  } catch (Exception e) {
    throw new RuntimeException("Cannot locate '" + file + "'. " + e, e);
  }
}