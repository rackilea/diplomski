public class RunBatchFile {

    public ResultWrapper runBatch() {

        String filePath = "C:/Users/attsuap1/Desktop/test.bat";
        try {
            Process p = Runtime.getRuntime().exec(filePath);

            int exitVal = p.waitFor();

            return new ResultWrapper(exitVal == 0);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultWrapper(false);
        }
    }

}