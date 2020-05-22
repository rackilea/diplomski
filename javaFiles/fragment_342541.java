JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
StandardJavaFileManager sjfm = javaCompiler.getStandardFileManager(null, null, null); 

String[] options = new String[] { "-d", "output" };
File[] javaFiles = new File[] { new File("src/gima/apps/flip/TestClass.java") };

CompilationTask compilationTask = javaCompiler.getTask(null, null, null,
        Arrays.asList(options),
        null,
        sjfm.getJavaFileObjects(javaFiles)
);
compilationTask.call();