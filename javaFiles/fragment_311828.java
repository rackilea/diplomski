// first try our cache of loaded classes
if (loadedClasses.containsKey(name)) {
    return loadedClasses.get(name);
}

// that didn't work, maybe the class was compiled but not yet loaded
if (compiledClasses.containsKey(name)) {
    // get the representation from the cache
    InMemoryClassJavaFileObject inMemoryRepresentation = compiledClasses.get(name);
    // let our parent define the class
    Class<?> clazz = defineClass(name, inMemoryRepresentation.getData(), 0, inMemoryRepresentation.getData().length);
    // and store it in the cache for later retrieval
    loadedClasses.put(name, clazz);
    return clazz;
}