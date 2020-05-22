JavaCompiler jCompiler = ToolProvider.getSystemJavaCompiler();
List<String> options = Arrays.asList(
                           "-d", "./bin/",
                           path+".java");
int compilationResult = jCompiler.run(null, null, null, 
                options.toArray(new String[options.size()]));
if (compilationResult == 0) {
    mensaje = "Compiled the "+path+" to its .class";
    ClassLoader cLoader = ClassLoader.getSystemClassLoader();
    try {
        cLoader.loadClass("THE CLASS");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
} else {
    mensaje = "Couldnt compile.";
}