String classPath;
try {
  classPath = ...
} catch (IOException e) {
  classPath = defaultValue;
}
A.classPath = classPath;