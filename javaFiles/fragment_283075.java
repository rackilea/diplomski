package javaapplication1;

import java.io.*;

public class JavaApplication1 {

    public static void main(String[] args) {

        Process process;
        String softwareToCheck = "telnet"; // Change here

        try
        {       
            if(!_softwareExists(softwareToCheck))
            {
                System.out.println("Installing missing software..");
                process = Runtime.getRuntime().exec(new String[]{"/bin/bash","-c","'echo RIadminXsrv1 | sudo -S apt-get install telnet -qy'"});

                try
                {
                    process.waitFor();
                }
                catch(InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }

                if(!_softwareExists(softwareToCheck))
                {
                    System.out.println("Software is still missing!");
                }

            }
            else
            {
                System.out.println("Software is installed!");
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }        
    }

    private static boolean _softwareExists(String binaryName) throws IOException
    {
        String line;
        ProcessBuilder builder;
        BufferedReader reader;
        Process process;

        builder = new ProcessBuilder("/usr/bin/which", binaryName);
        builder.redirectErrorStream(true);
        process = builder.start();
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        try
        {
            process.waitFor();
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

        while ((line = reader.readLine ()) != null)
        {
            break; // Reads only the first line
        }

        return (line != null && !line.isEmpty());

    }
}