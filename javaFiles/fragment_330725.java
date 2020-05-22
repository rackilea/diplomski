public class OddEvenFileManager {

    public static final String DATA_SOURCE_PATH = "sourceDatas.txt";
    public static final String ODD_TARGET_PATH =  "oddDatas.txt";
    public static final String EVEN_TARGET_PATH = "evenDatas.txt";


    public static void doOddEvenSplitting() throws IOException,     NumberFormatException {

        BufferedReader sourceReader = new BufferedReader(new FileReader(new     File(DATA_SOURCE_PATH)));
        BufferedWriter oddWriter = new BufferedWriter(new FileWriter(new     File(ODD_TARGET_PATH)));
        BufferedWriter evenWriter = new BufferedWriter(new FileWriter(new     File(EVEN_TARGET_PATH)));

        String sourceLine = null;

        while ((sourceLine = sourceReader.readLine()) != null) {
            int lineNumber = Integer.parseInt(sourceLine.split(" ")[0]);

            if (lineNumber % 2 == 0) {
                evenWriter.write(sourceLine);
                evenWriter.newLine();

            } else {
                oddWriter.write(sourceLine);
                oddWriter.newLine();
            }

        }

        sourceReader.close();
        oddWriter.close();
        evenWriter.close();

    }

    public static void main(String[] args) throws IOException,     NumberFormatException {
        doOddEvenSplitting();
    }
}