// main
String className = "tests.compiler.DynamicCompilationHelloWorldEtc";
//...
ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); 
File classesDir = new File(tempDir);
CustomClassLoader ccl = new CustomClassLoader(classLoader, classesDir);         
if (ccl != null) {
    Class clazz = ccl.loadClass(className);
///...
}