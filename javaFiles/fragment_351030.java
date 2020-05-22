public class StreamWrapper {

    private FileOutputStream fileOutputStream;

    public FileOutputStream open(String file) {
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            // Define action
        }
        return fileOutputStream;
    }

    public void close() {
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            // Define action
        }
    }

}