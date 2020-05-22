public class WriteInts {

    private String fname;

    public WriteInts(String fname) {
        this.fname = fname;
    }

    public void write(int... a) throws IOException {
        File file = new File(fname);
        try {
            System.out.println("WRiting to-" + file.getAbsolutePath());

            if (!file.exists())
                file.createNewFile();
            file.canRead();

        } catch (IOException x) {
            x.printStackTrace();
        }
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < a.length; i++) {
            outputWriter.write(Integer.toString(a[i]));
            /*
             * Add new line to keep them seperated
             */
            outputWriter.newLine();
        }
        /*
         * Flush and close the stream
         */
        outputWriter.flush();
        outputWriter.close();

    }

    public static void main(String[] args) {

        int myArr[] = { 16, 31, 90, 45, 89 };
        try {
            WriteInts wi = new WriteInts("mydata.dat");
            wi.write(myArr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}