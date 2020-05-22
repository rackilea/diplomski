JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, Locale.US, Charset.defaultCharset());
File[] files = new File[]{new File("/path/to/java/source/file/you/want/to/compile")};
DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

Iterable<? extends JavaFileObject> compilationUnits1 =
        fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files));
Boolean call = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits1).call();
for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
    System.out.println(diagnostic);

}

System.out.println("compiled successfully: " + call);