// get apache.common.exec.jar at:
http://commons.apache.org/proper/commons-exec/download_exec.cgi

import java.io.IOException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;


public class RunRsync {

public static void main(String[] args) throws IOException {

    try {

    //example :  String line = "C://file.exe";
    String line = "cmd /c start";   //you can put your .exe path here, like mine i run my window cmd
    CommandLine cmdLine = CommandLine.parse(line);
    DefaultExecutor executor = new DefaultExecutor(); 
    int exitValue = executor.execute(cmdLine);

    }
    catch (Exception exc){     
       System.out.println("error" + exc);/*handle exception*/} 
    }    
}