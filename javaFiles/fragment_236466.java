JarClassLoader jcl = new JarClassLoader();

  //Loading classes from different sources
  jcl.add("myjar.jar");
  jcl.add(new URL("http://myserver.com/myjar.jar"));
  jcl.add(new FileInputStream("myotherjar.jar"));
  jcl.add("myclassfolder/");

  //Recursively load all jar files in the folder/sub-folder(s)
  jcl.add("myjarlib/");

  JclObjectFactory factory = JclObjectFactory.getInstance();

  //Create object of loaded class
  Object obj = factory.create(jcl, "mypack.MyClass");