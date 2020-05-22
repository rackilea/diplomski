/* DataReceivedEvent.java */
public class DataReceivedEvent extends EventObject{
    private String data;
    public DataReceivedEvent(Object source, String temp) {
        super(source);
        // TODO Auto-generated constructor stub
        data = temp;
    }
    public String getData() {
            // this function is just an accessor function
        return data;
    }
}