JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
Path tmp=Files.createTempDirectory("compile-test-");
fileManager.setLocation(StandardLocation.CLASS_OUTPUT,Collections.singleton(tmp.toFile()));
Path src=tmp.resolve("A.java");
Files.write(src, Arrays.asList(
        "package test;",
        "class A {",
        "    class B {",
        "    }",
        "}"
));
CompilationTask task = compiler.getTask(null, fileManager,
        null, null, null, fileManager.getJavaFileObjects(src.toFile()));
if(task.call()) {
    for(JavaFileObject jfo: fileManager.list(StandardLocation.CLASS_OUTPUT,
                            "", Collections.singleton(JavaFileObject.Kind.CLASS), true)) {
        System.out.println(jfo.getName());
    }
}