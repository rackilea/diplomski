/*

# cat GenerateKey.java
javac GenerateKey.java
java GenerateKey

# For more information see the "Java exec and Unix pipes" comment in:
# "Java exec - execute system processes with Java ProcessBuilder and Process (part 3)",
# http://alvinalexander.com/java/java-exec-processbuilder-process-3

*/

import java.io.*;
import java.util.*;

public class GenerateKey {
    public static void main(String[] args) throws Exception {
        Runtime run = Runtime.getRuntime();

        // does not work on Mac OS X 10.6.8
        //String[] cmd = { "/bin/sh", "-c", "LC_ALL=C tr -cd '[:alnum:]' < /dev/urandom | fold -w30 | head -n1; echo;" };  

        // works
        String[] cmd = { "/bin/sh", "-i", "-c", "LC_ALL=C tr -cd '[:alnum:]' < /dev/urandom | fold -w30 | head -n1; echo;" };  
        //String[] cmd = { "/bin/sh", "-c", "head -c 3000 < /dev/urandom | LC_ALL=C tr -cd '[:alnum:]' | head -c 30" }; 
        //String[] cmd = { "/bin/sh", "-c", "dd if=/dev/urandom bs=3000 count=1 2>/dev/null | LC_ALL=C tr -cd '[:alnum:]' | fold -w30 | head -n1" }; 
        Process pr = run.exec(cmd);

        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;
        while ((line = buf.readLine())!= null ) {
            System.out.println(line);
        }
    }
}