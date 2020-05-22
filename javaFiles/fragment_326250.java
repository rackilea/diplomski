ctClasses = new HashMap<String, CtClass>();
classPool = ClassPool.getDefault();

//Add the classloader of your application's classes so Javassist can find them
ClassLoader loader = org.MyClass.class.getClassLoader();
pool.appendClassPath(new LoaderClassPath(loader));

try {
    ctEntity = classPool.get("org.MyClass");
} catch (NotFoundException e) {
    logger.error("Could not find entity class, this should not happen");
    throw new RuntimeException("Could not find Entity class",e);
}