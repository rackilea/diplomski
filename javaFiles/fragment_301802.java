public class PeteProgram {
    public static void main(String[] args) {
        String peteFilename = "MyRecordsFile.txt";
        //here's when the physical file is created
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(peteFilename), "utf-8"))) {
        PeteFileMgr peteFileMgr = new PeteFileMgr(writer);

        peteFileMgr.addThisString(writer, "Add this line #1\n");
        peteFileMgr.addThisString(writer, "Add this line #2\n");
        peteFileMgr.addThisString(writer, "Add this line #3\n");
        } catch (IOException e) {
            //handle the exception
            //basic handling
            e.printStacktrace();
        }
    }
}