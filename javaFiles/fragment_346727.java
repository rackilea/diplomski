private static void scanClasses(File file) throws MalformedURLException, IOException {
    ClassLoader classLoader = new URLClassLoader(new URL[]{ file.toURI().toURL() });
    JarFile jar = new JarFile(file.getAbsoluteFile());
    Enumeration<JarEntry> jarEntries = jar.entries();
    while (jarEntries.hasMoreElements()) {
      JarEntry je = jarEntries.nextElement();
      if (je.getName().endsWith(".class")) {
        String clazzName = je.getName();
        clazzName = clazzName.substring(0, clazzName.length() - ".class".length()).replaceAll("/", ".");
        clazzName = clazzName.replaceAll("/", ".");
        try {
          Class clazz = Class.forName(clazzName, false, classLoader);
          if (Randomizer.class.isAssignableFrom(clazz)) {
            System.out.println("Found Randomizer: " + clazz);
          }
        } catch (ClassNotFoundException ex) {
          // this really should not happen, 
          // since we *know* the class exists
          throw new AssertionError(ex.getMessage());
        }
      }
    }
  }