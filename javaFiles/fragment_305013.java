public static Class<?> compile(ClassLoader parent, String className, String sourceCodeInText) throws Exception {
        SourceCode sourceCode = new SourceCode(className, sourceCodeInText);
        CompiledCode compiledCode = new CompiledCode(className);
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(sourceCode);
        DynamicClassLoader cl = new DynamicClassLoader(parent);
        ExtendedStandardJavaFileManager fileManager = new ExtendedStandard(
                javac.getStandardFileManager(null, null, null), compiledCode, cl);

        // set the classpath
        List<String> options = new ArrayList<String>();

        options.add("-classpath");
        StringBuilder sb = new StringBuilder();
        Enumeration<URL> resources = parent.getResources("/");
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            sb.append(url.getFile()).append(File.pathSeparator);
        }

        options.add(sb.toString());

        // execute the compiler
        Boolean call = javac.getTask(null, fileManager, null, options, null, compilationUnits).call();
        if (call) {
            return cl.loadClass(className);
        }
        return null;
    }