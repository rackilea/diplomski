public class Test {
    void writeLog(String s) {
        try {
            String filename = "C:\\Temp\\Logs.txt";
            FileWriter fw = new FileWriter(filename, true);
            fw.write(s + "\n");
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        Test t1 = new Test();

        for (int i = 0; i < 5; i++) {
            t1.writeLog("Hello");
        }

    }
}