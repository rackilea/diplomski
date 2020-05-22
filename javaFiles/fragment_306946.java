public class MyFileInputStream extends FileInputStream {
    private final File myFile;

    public MyFileInputStream(File file) throws FileNotFoundException {
        super(file);
        myFile = file;
    }
    @Override
    public void close() throws IOException {
        super.close();
        myFile.delete();
    }
}