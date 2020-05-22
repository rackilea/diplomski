import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriveDetails {

    public static void main(String[] args) {
        String command = "wmic logicaldisk where drivetype=$$ get deviceid";
        for (DriveType driveType : DriveType.values()) {
            String query = command.replace("$$", String.valueOf(driveType.getType()));
            System.out.println(driveType.getDescription());
            System.out.println(executeCommand(query).trim());
        }
    }

    private static String executeCommand(String command) {
        StringBuffer output = new StringBuffer();
        Process p = null;
        BufferedReader reader = null;
        try {
            p = Runtime.getRuntime().exec(command);
            reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line = "";
            boolean flag = true;
            while ((line = reader.readLine()) != null) {
                if(flag) {
                    flag = false;
                    continue; // Skipping header
                }
                output.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (p != null)
                p.destroy();
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return output.toString();
    }

    enum DriveType {
        UNKNOWN(0, "Unknown"),
        NO_ROOT_DIRECTORY(1, "No Root Directory"),
        REMOVABLE_DISK(2, "Removable Disk"),
        LOCAL_DISK(3, "Local Disk"),
        NETWORK_DRIVE(4, "Network Drive"),
        COMPACT_DISC(5, "Compact Disc"),
        RAM_DISK(6, "RAM Disk");

        private DriveType(int type, String description) {
            this.type = type;
            this.description = description;
        }

        private int type;
        private String description;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}