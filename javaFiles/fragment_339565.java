public class MyAgent {
    public static void premain(String agentArgs, Instrumentation inst) throws IOException {
        JarURLConnection connection = (JarURLConnection)
            MyAgent.class.getResource("MyAgent.class").openConnection();
        inst.appendToBootstrapClassLoaderSearch(connection.getJarFile());

        // proceed
    }
}