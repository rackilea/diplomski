import java.io.*;

public class Main {

       public static void main(String args[]) {

            try {
                Runtime rt = Runtime.getRuntime();
                //Process pr = rt.exec("cmd /c dir");
                Process pr = rt.exec("c:\\helloworld.exe");

                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

                String line=null;

                while((line=input.readLine()) != null) {
                    System.out.println(line);
                }

                int exitVal = pr.waitFor();
                System.out.println("Exited with error code "+exitVal);

            } catch(Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }
}