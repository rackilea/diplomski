public class FromFileGenerator implements Generator {
    ...
    public String generate() {
        try {
            String output = //read from some file
            return file;
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}