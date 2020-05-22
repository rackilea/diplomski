/*
 * Method to compile a class which doesn't extend a class that's been compiled from memory.
 */
public static Class<?> compile(String className, String sourceCode, URLClassLoader classLoader) throws Exception {
    return compileHelper(className, classLoader, Arrays.asList(new JavaSourceFromString(className, sourceCode)));
}

/*
 * Method to compile a class which extends a class that's been compiled from
 * memory.
 * 
 * This method takes in the class name, a Set of Map.Entry<String, String>,
 * which contains class names and their sources, and a class loader. This
 * method iterates over the entries in the Set, creates JavaFileObjects from
 * the class names and their sources and adds each JavaFileObject to an
 * ArrayList which will be used in the 'compileHelper' method.
 */
public static Class<?> compile(String className, Set<Map.Entry<String, String>> nameAndSource, URLClassLoader classLoader) throws Exception {
    List<JavaFileObject> compilationUnits = new ArrayList<>();

    for(Entry<String, String> entry : nameAndSource) {
        compilationUnits.add(new JavaSourceFromString(entry.getKey(), entry.getValue()));
    }

    return compileHelper(className, classLoader, compilationUnits);
}