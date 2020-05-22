/*
 * Helper method that actually does the compiling.
 */
private static Class<?> compileHelper(String className, URLClassLoader classLoader, Iterable<? extends JavaFileObject> compilationUnits) throws Exception {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
    CompilationTask task = null;
    boolean success = false;

    // debug compilation units section
    System.out.println("Compiling " + className);

    System.out.println(" - compilationUnits ");
    for(JavaFileObject o : compilationUnits) {
        System.out.println("   + " + o.toString());
    }
    // end debug

    task = compiler.getTask(null, null, diagnostics, null, null, compilationUnits);
    success = task.call();

    if (success) {
        System.out.println("Successful compilation of " + className);
        return Class.forName(className.replace(".", "/"), true, classLoader);
    } else {
        System.out.println("Failed while compiling " + className);
        printDiagnostics(diagnostics);
        throw new Exception("It didn't work!");
    }
}