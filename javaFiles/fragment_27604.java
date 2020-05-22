Enumeration<JarEntry> entries = jarFile.entries();
MyClassLoader classLoader = new MyClassLoader();
// First we generate ALL classes that the class loader is supposed to load.
// We then make these classes accessible to the class loader.
while (entries.hasMoreElements()) {
  JarEntry element = entries.nextElement();
  if (element.getName().endsWith(".class")) {
     // Class Manipulation via ASM
     classLoader.addClass( ... );
  }
}
// Now that the class loader knows about all classes that are to be loaded
// we trigger the loading process. That way, the class loader can query
// itself about ANY class that it should know.
while (entries.hasMoreElements()) {
  JarEntry element = entries.nextElement();
  if (element.getName().endsWith(".class")) {
     classLoader.loadClass( ... );
  }
}