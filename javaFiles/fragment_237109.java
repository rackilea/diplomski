// method to start class in another JVM process
public static void startProcess(Class<?> clazz) throws Exception {
    System.out.println(clazz.getCanonicalName());
    String separator = System.getProperty("file.separator");
    String classpath = System.getProperty("java.class.path");
    String path = System.getProperty("java.home") + separator + "bin" + separator + "java";
    ProcessBuilder processBuilder = new ProcessBuilder(path, "-cp", classpath, clazz.getCanonicalName());
    Process process = processBuilder.start();
    process.waitFor();
}

// run in another process
startProcess(AnotherClass.class);