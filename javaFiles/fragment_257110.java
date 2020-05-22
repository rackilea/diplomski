import java.io.IOException;

public class StrangeError {
    public static void main(String[] args) {
        try {
            ProcessBuilder processb = new ProcessBuilder(
                "cmd",
                "/c",
                "\"C:\\Program Files (x86)\\Microsoft Visual Studio 14.0\\VC\\vcvarsall.bat\" amd64 && set"
            );
            processb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process process = processb.start();
            process.waitFor();
        } catch (IOException|InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}