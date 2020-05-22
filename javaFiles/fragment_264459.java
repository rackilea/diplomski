JarInputStream stream = null;

try {   

  File jar = new File("/path/to/jar.jar");
  stream = new JarInputStream(new FileInputStream(jar));
  String mainClass = stream.getManifest().getMainAttributes().getValue("Main-class");
  ClassLoader loader = URLClassLoader.newInstance(new URL[] { jar.toURI().toURL() }, getClass().getClassLoader);
  Class<?> main = Class.forName(mainClass, loader);
  main.getDeclaredMethod("main", String[].class).invoke(null, null);

} finally {
  stream.close();
}