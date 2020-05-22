import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Root related operations.
 */
public class RootPrivileges {
    public static final String TAG = "RootPrivileges";

    private RootPrivileges() {
        Log.e(TAG, "RootPrivileges should not be instantiated");
    }

    /**
     * Checks and asks for Root privileges
     *
     * @return true if has root privileges, false otherwise
     */
    public static boolean hasRoot() {
        boolean resp = false;
        Process suProcess;
        try {
            suProcess = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(suProcess.getOutputStream());
            DataInputStream osRes = new DataInputStream(suProcess.getInputStream());
            if (os != null && osRes != null) {
                os.writeBytes("id\n");
                os.flush();
                String currUid = osRes.readLine();
                boolean exitSu;
                if (null == currUid) {
                    resp = false;
                    exitSu = false;
                    Log.e(TAG, "No root privileges, or denied by user");
                } else if (currUid.contains("uid=0")) {
                    resp = true;
                    exitSu = true;
                    Log.v(TAG, "Root privileges given");
                } else {
                    resp = false;
                    exitSu = true;
                    Log.e(TAG, "Not enough privileges.\n   Received: " + currUid + "\n   Expected: 0");
                }
                if (exitSu) {
                    os.writeBytes("exit\n");
                    os.flush();
                }
            }
        } catch (Exception e) {
            resp = false;
            Log.e(TAG, "Root privileges denied. [" + e.getClass().getName() + "] : " + e.getMessage());
        }
        return resp;
    }

    /**
     * Executes a command as root.
     *
     * @param cmd the command.
     * @return if code was sent to execute
     */
    public static final boolean execute(String cmd) {
        try {
            if (cmd != null && cmd.length() > 0) {
                Process suProcess = Runtime.getRuntime().exec("su");
                DataOutputStream dataOutputStream = new DataOutputStream(suProcess.getOutputStream());
                DataInputStream dataInputStream = new DataInputStream(suProcess.getInputStream());
                DataInputStream dataErrorStream = new DataInputStream(suProcess.getErrorStream());

                dataOutputStream.writeBytes(cmd);
                dataOutputStream.writeBytes("\n");
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");

                BufferedReader reader = new BufferedReader(new InputStreamReader(dataInputStream));
                BufferedReader err_reader = new BufferedReader(new InputStreamReader(dataErrorStream));
                String resp;
                while ((resp = reader.readLine()) != null) {
                    Log.v(TAG, "[resp]" + resp);
                }
                while ((resp = err_reader.readLine()) != null) {
                    Log.v(TAG, "[err_resp]" + resp);
                }
                reader.close();
                err_reader.close();
                dataOutputStream.flush();
                try {
                    int suProcessRetval = suProcess.waitFor();
                    suProcess.destroy();
                    return (suProcessRetval != 255);
                } catch (Exception ex) {
                    Log.e(TAG, "Error in Root command execution");
                    ex.printStackTrace();
                }
            } else {
                Log.e(TAG, "command is null or empty");
            }
        } catch (IOException ex) {
            Log.e(TAG, "IOException");
            ex.printStackTrace();
        } catch (SecurityException ex) {
            Log.e(TAG, "SecurityException");
            ex.printStackTrace();
        } catch (Exception ex) {
            Log.e(TAG, "Generic Exception");
            ex.printStackTrace();
        }
        return false;
    }
}