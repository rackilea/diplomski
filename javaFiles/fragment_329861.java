import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.jar.JarFile;

public class PremainLauncher {
    public static void premain(String args, Instrumentation inst) throws IOException{
        inst.appendToSystemClassLoaderSearch(new JarFile("Code.jar"));
        inst.addTransformer(new Transformer(), true);
        System.out.println("Registered instruction for package: " + args);
    }
}