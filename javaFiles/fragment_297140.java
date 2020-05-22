public static void main(String args[]) throws Exception {
    Map<String, String> nameAndSource = new HashMap<>();
    URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { new File("").toURI().toURL() });
    String className;
    StringBuilder sourceCode;

    // HelloWorld class
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

    // ExtendedHelloWorldClass
    className = "ExtendedHelloWorld";
    sourceCode = new StringBuilder();
    sourceCode.append("public class ExtendedHelloWorld extends HelloWorld {");
    sourceCode.append("  public int num = 2;");
    sourceCode.append("}");

    // add ExtendedHelloWorld class name and source code to HashMap
    nameAndSource.put(className, sourceCode.toString());

    // here's where we pass in the nameAndSource entrySet()
    Class<?> extendedHelloWorld = compile(className, nameAndSource.entrySet(), classLoader);

    return;
}