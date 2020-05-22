/* DataBuilderEvent.java */
public class DataBuilderEvent extends EventObject {
    private String data;
    public DataBuilderEvent(Object source, String temp) {
        super(source);
        // TODO Auto-generated constructor stub
        data = temp;
    }
    public String getData() {
            // this function is just an accessor function
        return data;
    }
}