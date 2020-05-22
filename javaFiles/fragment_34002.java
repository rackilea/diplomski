public class RunBatchFile {

    public boolean runBatch() {

        String filePath = "C:/Users/attsuap1/Desktop/test.bat";
        try {
            Process p = Runtime.getRuntime().exec(filePath);

            int exitVal = p.waitFor();

            return exitVal == 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}