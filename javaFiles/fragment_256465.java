public void javaCompile(String fileName) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//      DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null/*diagnostics*/, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager
            .getJavaFileObjectsFromStrings(Arrays.asList(fileName));
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null/*diagnostics*/, null,
            null, compilationUnits);
        boolean success = task.call();
        fileManager.close();
        System.out.println("Success: " + success);
    }