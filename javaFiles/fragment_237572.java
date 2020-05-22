public class ServerResponse<T> { 
    private int code;
    private String msg;
    private List<T> data;

    public List<T> getResponseObjectList(){
        return data;
    }
}