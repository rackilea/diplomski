public class PortConfiguration extends JDialog() {
    private int baudrate;
    private String moreStuff;

    //show window, events and more
    public PortConfiguration() {
        super(null,true);
        this.setVisible( false );
        //GUI creation...
    }

    //get configuration:
    public int getBaudrate() {}
    public String getStuff() {}
}