public abstract class ExternalScript extends Script {

    private String source;

    public void setSource(String file) {
        source = file;
    }

    public String getSource() {
        return source;
    }
}