import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class VersionChecker {

    public static String getVersion(File storeDir) {
        File debugLog = new File(storeDir, "logs" + File.separator + "debug.log");
        if(debugLog.exists()) {
            try {
                //The ReversedLinesFileReader reads the last line of a file first and so on
                ReversedLinesFileReader reader = new ReversedLinesFileReader(debugLog, StandardCharsets.UTF_8);
                //Read last line
                String line = reader.readLine();
                while(line!=null) {
                    //Line can't be null at this point

                    if(line.contains("Kernel version: ")) {
                        //This line contains the version
                        line = line.substring(line.indexOf("Kernel version: ")).substring(16);  //get rid of everything except the version
                        line = line.split(",")[0];  //get rid of the second part of the Kernel version that we don't want
                        return line;
                    }

                    //Next line
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}