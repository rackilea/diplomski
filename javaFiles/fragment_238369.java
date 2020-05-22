public class Backup{
    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException {
        final String cmd = "pg_dump  --format=c --username \"postgres\" db_name > \"D:\\pgBackup\\db_name.backup\"";

        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        java.lang.Process p = rt.exec(cmd);
    }
}