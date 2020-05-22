Class klass=Program.class;
String[] output=new String[2];
String javaHome = System.getProperty("java.home");
String javaBin = javaHome +
     File.separator + "bin" +
     File.separator + "java";
String classpath = System.getProperty("java.class.path");
String className = klass.getCanonicalName();

ProcessBuilder builder = new ProcessBuilder(
     javaBin, "-cp", classpath, className);
builder.redirectErrorStream(true);

Process process = builder.start();
int in = -1;
InputStream is = process.getInputStream();
try {
    while ((in = is.read()) != -1) {
        System.out.println((char)in);
    }
} catch (IOException ex) {
    ex.printStackTrace();
}
int exitCode = process.waitFor();
System.out.println("Exited with " + exitCode);