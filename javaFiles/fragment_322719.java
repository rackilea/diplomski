public class LogFileHeaderPatternLayout extends PatternLayout {

    private String header;

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String getFileHeader() {
        return header;
    }
}