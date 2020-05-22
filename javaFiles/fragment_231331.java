@Override
protected void configure() {
  try {
    for (ClassInfo classInfo: 
          ClassPath.from(getClass().getClassLoader()).getTopLevelClasses("my.package.name")) {
        bind(classInfo.load()).asEagerSingleton();
    }
  } catch (IOException e) { // Do something
  }
}