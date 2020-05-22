import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class WindowsSymlinkUtility {

    public static final String D_LINK = "/D";
    public static final String H_LINK = "/H";
    public static final String J_LINK = "/J";
    public static final String REM_LINK = "rmdir";

    private String command, flag, link, target;
    private List<String> commands = Arrays.asList(D_LINK, H_LINK, J_LINK, REM_LINK), symlinks;

    public WindowsSymlinkUtility() {
        this.command = this.flag = this.link = this.target = "";
        this.symlinks = new ArrayList<>();
    }

    /**
     * Automatically creates a directory junction
     * @param String link - the path and name of the symlink
     * @param String target - the directory to point the symlink to
     * @return boolean
     * @see http://ss64.com/nt/mklink.html
     */
    public boolean createSymlink(String link, String target) {
        return createSymlink(J_LINK, link, target);
    }

    /**
     *
     * @param String flag - the flag for mklink
     * @param String link - the path and name of the symlink
     * @param String target - the directory to point the symlink to
     * @return boolean
     * @see http://ss64.com/nt/mklink.html
     */
    public boolean createSymlink(String flag, String link, String target) {
        if(!this.commands.contains(flag)) {
            System.err.printf("%s is not a valid command\n", flag);
            return false;
        }

        this.command = "mklink";
        this.flag = flag;
        this.link = link;
        this.target = target;

        if(this.runner() == 0) {
            this.symlinks.add(this.link);
            return true;
        }

        return false;
    }

    private int runner() {
        Process process = null;
        String message = null;
        BufferedInputStream bis = null;
        StringBuilder strBuff = new StringBuilder();
        int exitVal = -1;

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", this.command, this.flag, this.link, this.target);
            Map<String, String> envVars = pb.environment();

            pb.directory();
            pb.redirectErrorStream(true);
            process = pb.start();
            bis = new BufferedInputStream(process.getInputStream());
            byte[] bArr = new byte[2048];
            while (bis.read(bArr) != -1) {
                strBuff.append(new String(bArr).trim());
                bArr = new byte[2048];
            }

            exitVal = process.waitFor();
            message = strBuff.toString();
            System.out.println(message);
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            System.err.println(message);
        }

        return exitVal;
    }

    public static void main(String[] args) {
        (new WindowsSymlinkUtility()).createSymlink(J_LINK, "%TEMP%\\node", "C:\\users\\djthomps\\Downloads");
    }

}