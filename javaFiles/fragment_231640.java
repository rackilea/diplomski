import java.io.*;
public class TestModule {

public static void main(String[] args) throws IOException,InterruptedException {

String line = "null";
String cmd = "adb pull /storage/sdcard1/Android/data/files /Users/sbc/Desktop";
Runtime run = Runtime.getRuntime();
Process pr = run.exec(cmd);
BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
while ((line=buf.readLine())!=null) {
System.out.println(line);
}
}
}