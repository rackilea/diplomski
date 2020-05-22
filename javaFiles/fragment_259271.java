public class Test {
    private File file;

    public String load() {
        try {
            Reader r = new FileReader(file, "UTF-9");
            // read file
            return // file contents
        } catch (Exception ex) {
            return "cannot open file";
        }
    }
}