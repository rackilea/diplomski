import java.util.List;

import org.apache.log4j.Logger;

import com.jscape.inet.sftp.Sftp;
import com.jscape.inet.sftp.SftpException;
import com.jscape.inet.sftp.events.SftpAdapter;
import com.jscape.inet.ssh.util.SshParameters;

public class SFTPExample extends SftpAdapter {
     static String hostName = "hostname";
     static String username = "username";
     static String password = "password";;
     static String directory = "directory";;
    private static Sftp sftp;

    private static org.apache.log4j.Logger log = Logger.getLogger(SFTPExample.class);

    @SuppressWarnings("unchecked")
    public static boolean deleteDir(List <String> path) throws SftpException {
        log.info("------------------------ file(s) delete started ------------------------");
        sftp = new Sftp(new SshParameters(hostName, username, password));

        sftp.connect();
        sftp.setDir(directory);

        for (String eachOne : path) {
            if (!sftp.getDirListingAsString(eachOne).equals("")){
                log.info(" ------ File Name: " + eachOne);
                System.out.println(directory+eachOne);
                sftp.deleteDir(directory+eachOne, true);
            }
        }

        sftp.disconnect();
        log.info("------------------------ file(s) delete finished -----------------------");

        return true;
    }

    // open connection to the remote server.
    public static void openConnection() throws SftpException {
        sftp.connect();
    }

    // disconnect from the remote server.
    public static void closeConnection() {
        sftp.disconnect();
    }
}