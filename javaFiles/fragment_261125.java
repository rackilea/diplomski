public class RollingFileHandler extends FileHandler {

    public RollingFileHandler() throws IOException {
        super(fileName(), 0, 1, true);
    }

    private static String fileName() {
        return new SimpleDateFormat("'%h'yyyyMMdd_HHmmss").format(new Date(System.currentTimeMillis()));
    }
}