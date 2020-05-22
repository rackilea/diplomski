Properties p = new Properties();
p.setProperty("resource.loader", "class");
p.setProperty("class.resource.loader.description", "Velocity Classpath Resource Loader");
p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

    try {
      Velocity.init(p);
    } catch(...., and handle excpetion
  }