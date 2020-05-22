import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;

public class ProcessBuilderMultipleCommandsExample {
    private static String path = "C:\\Users\\xxA\\Desktop";

    public static void main(String[] args) 
        throws InterruptedException, IOException {

        execute("cmd.exe", "/c", "cd " + path + " && javac " + "NumberScan" + ".java"); 
        execute("cmd.exe", "/c", "cd " + path + " && java  " + "NumberScan");
    }

    private static void execute(String ... commands) 
        throws IOException, InterruptedException
    {
        System.out.println("Executing "+Arrays.asList(commands));

        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        processBuilder.redirectInput(Redirect.INHERIT);
        processBuilder.redirectOutput(Redirect.INHERIT);
        processBuilder.redirectError(Redirect.INHERIT);

        Process process = processBuilder.start();
        process.waitFor();
    }
}