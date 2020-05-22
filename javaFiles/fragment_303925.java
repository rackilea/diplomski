URLClassLoader urlcl = new URLClassLoader(urls);
Reflections reflections = new Reflections(
  new ConfigurationBuilder().setUrls(
    ClasspathHelper.forClassLoader(urlcl)
  ).addClassLoader(urlcl)
);