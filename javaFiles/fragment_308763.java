/* DataSender.java */
/* this class has no event, because it is done firing events at this point */
public class DataSender {
    private String data;
    public boolean sendData(String temp) {
        data = temp;
        return true;
    }
}