import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Samtest extends Thread {

    public static void main(String[] args) throws IOException {

        String pythonScriptPath0 = "IR_Component_module11.py";
        String[] cmd0 = new String[3];
        cmd0[0] = "C:\\Python27\\python.exe";
        cmd0[1] = "-u";
        cmd0[2] = pythonScriptPath0;
        Runtime rt0 = Runtime.getRuntime();
        java.lang.Process pr0 = rt0.exec(cmd0);
        BufferedReader bfr0 = new BufferedReader(new InputStreamReader(pr0.getInputStream()));
        String line0 = "";
        while ((line0 = bfr0.readLine()) != null) {
            System.out.println(line0);
        }

    }
}