public class PeteProgram {
    public static void main(String[] args) {
        String peteFilename = "MyRecordsFile.txt";
        //here's when the physical file is created
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(peteFilename), "utf-8"));
        PeteFileMgr peteFileMgr = new PeteFileMgr(writer);

        peteFileMgr.addThisString(writer, "Add this line #1\n");
        peteFileMgr.addThisString(writer, "Add this line #2\n");
        peteFileMgr.addThisString(writer, "Add this line #3\n");
        } catch (IOException e) {
            //handle the exception
            //basic handling
            e.printStacktrace();
        } finally {
            //this is a must!
            try { writer.close(); } catch(IOException silent) { }
        }
    }
}

public class PeteFileMgr {
    public PeteFileMgr(Writer writer) {
        try {
            //this method is not creating the physical file
            writer.write("File created!");
        } catch (IOException ex) {
          // report
        } finally {
            //remove this call to close
            //try {writer.close();} catch (Exception ex) {}
        }
    }

    public void addThisString(Writer writer, String addThis) {
        try {
            writer.append(addThis);
        } catch (IOException ex) {
            // report
        } finally {
            //remove this call to close
            //try {writer.close();} catch (Exception ex) {}
        }
    }
}