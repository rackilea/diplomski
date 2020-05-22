public class CompileSourceInMemory {

    /*
     * Method to compile a class which extends a class that's been compiled from
     * memory.
     * 
     * This method takes in the class name, a Set of Map.Entry<String, String>,
     * which contains class names and their sources, and a class loader. This
     * method iterates over the entries in the Set, creates JavaFileObjects from
     * the class names and their sources and adds each JavaFileObject to an
     * ArrayList which will be used the private compile method.
     */
    public static Class<?> compile(String className, Set<Map.Entry<String, String>> nameAndSource, URLClassLoader classLoader) throws Exception {
        List<JavaFileObject> compilationUnits = new ArrayList<>();

        for (Entry<String, String> entry : nameAndSource) {
            compilationUnits.add(newJavaSourceFromString(entry.getKey(), entry.getValue()));
        }

        return compileHelper(className, classLoader, compilationUnits);
    }

    /*
     * Method to compile a class which doesn't extend a class that's been
     * compiled from memory.
     */
    public static Class<?> compile(String className, String sourceCode, URLClassLoader classLoader) throws Exception {
        return compileHelper(className, classLoader, Arrays.asList(new JavaSourceFromString(className, sourceCode)));
    }

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
        for (JavaFileObject o : compilationUnits) {
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

    public static void main(String args[]) throws Exception {
        Map<String, String> nameAndSource = new HashMap<>();
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { new File("").toURI().toURL() });
        String className;
        StringBuilder sourceCode;

        // HelloWorld Class
        className = "HelloWorld";
        sourceCode = new StringBuilder();
        sourceCode.append("public class HelloWorld {");
        sourceCode.append("  public static void main(String args[]) {");
        sourceCode.append("    System.out.append(\"This is in another java file\");");
        sourceCode.append("  }");
        sourceCode.append("}");

        // pass the class name and source code to 'compile'
        Class<?> helloWorld = compile(className, sourceCode.toString(), classLoader);

        // add HelloWorld class name and source code to HashMap
        nameAndSource.put(className, sourceCode.toString());

        // ExtendedHelloWorld Class
        className = "ExtendedHelloWorld";
        sourceCode = new StringBuilder();
        sourceCode.append("public class ExtendedHelloWorld extends HelloWorld {");
        sourceCode.append("  public int num = 2;");
        sourceCode.append("}");

        // add ExtendedHelloWorld class name and source code to HashMap
        nameAndSource.put(className, sourceCode.toString());

        // pass the nameAndSource entrySet() to 'compile'
        Class<?> extendedHelloWorld = compile(className, nameAndSource.entrySet(), classLoader);

        // ExtendedExtendedHelloWorld Class
        className = "ExtendedExtendedHelloWorld";
        sourceCode = new StringBuilder();
        sourceCode.append("public class ExtendedExtendedHelloWorld extends ExtendedHelloWorld {");
        sourceCode.append("  public void printNum() { System.out.println(num); }");
        sourceCode.append("}");

        // add ExtendedExtendedHelloWorld class name and source code to HashMap
        nameAndSource.put(className, sourceCode.toString());

        // pass the nameAndSource entrySet() to 'compile'
        Class<?> extendedExtendedHelloWorld = compile(className, nameAndSource.entrySet(), classLoader);
        Object eehw = extendedExtendedHelloWorld.newInstance();

        return;
    }

    private static void printDiagnostics(DiagnosticCollector<JavaFileObject> diagnostics) {
        StringBuilder sb = new StringBuilder("-- Diagnostics --\n");
        for (Diagnostic<?> d : diagnostics.getDiagnostics()) {
            sb.append(String
                    .format("d.getCode() - %s%nd.getKind() - %s%nd.getPosition() - %d%nd.getStartPosition() - %d%nd.getEndPosition() - %d%nd.getSource() - %s%nd.getMessage(null) - %s%n",
                            d.getCode(), d.getKind().toString(),
                            d.getPosition(), d.getStartPosition(),
                            d.getEndPosition(), d.getSource().toString(),
                            d.getMessage(null)));
        }
        System.out.println(sb.append("--").toString());
    }
}

class JavaSourceFromString extends SimpleJavaFileObject {
    final String code;

    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/')
                + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}