public class Connect2 {
    private String url;
    public String name;
    public Connect3 me;
    public Connect2(String name) {// and the rest of your arguments
        this.name = name;
    }
    public void execute() {
        me = new Connect3(this.url);
        me.connect();
    }
    public void setURL(String url) {
        this.url = url;
    }
}