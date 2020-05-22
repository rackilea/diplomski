import java.io.IOException;
import java.io.PrintWriter;

public class TestClass {
    public static void main(String[] args) throws IOException {
        String jarFileName = "someJar.jar";
        String scriptFileName = "/tmp/script.sh";

        PrintWriter writer = new PrintWriter(scriptFileName, "UTF-8");
        writer.println("#!/usr/bin/env bash");
        writer.println("/usr/bin/java - jar '" + jarFileName + "'");
        writer.close();
        Runtime.getRuntime().exec("chmod u+x " + scriptFileName);
        Runtime.getRuntime().exec(new String[] {"/usr/bin/open", "-a", "Terminal", scriptFileName});
    }
}