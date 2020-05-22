public class MagicWrapper {
    private String value;

    /* need to proxy */
    public MagicWrapper() {   
    }

    public MagicWrapper(String value) {
        this.value = value;
    }

    public String get() {
        return this.value;
    }
}