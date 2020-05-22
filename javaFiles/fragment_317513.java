package runaccessmacro;

import java.io.*;

public class RunAccessMacro {

    public static void main(String[] args) {
        String dbFilePath = "C:\\Users\\Public\\Database1.accdb";
        String vbsFilePath = System.getenv("TEMP") + "\\javaTempScriptFile.vbs";
        File vbsFile = new File(vbsFilePath);
        PrintWriter pw;
        try {
            pw = new PrintWriter(vbsFile);
            pw.println("Set accessApp = CreateObject(\"Access.Application\")");
            pw.println("accessApp.OpenCurrentDatabase \"" + dbFilePath + "\"");
            pw.println("accessApp.DoCmd.RunMacro \"doRidLogUpdate\"");
            pw.println("accessApp.CloseCurrentDatabase");
            pw.println("accessApp.Quit");
            pw.close();

            Process p = Runtime.getRuntime().exec("cscript /nologo \"" + vbsFilePath + "\"");
            p.waitFor();
            BufferedReader rdr = 
                    new BufferedReader(new InputStreamReader(p.getErrorStream()));
            int errorLines = 0;
            String line = rdr.readLine();
            while (line != null) {
                errorLines++;
                System.out.println(line);  // display error line(s), if any
                line = rdr.readLine();
            }
            vbsFile.delete();
            if (errorLines == 0) {
                System.out.println("The operation completed successfully.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}