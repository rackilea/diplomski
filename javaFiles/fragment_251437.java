public class RestResponse<T>{

    private String message;
    private T obj;

    public RestResponse(String message, T obj){
    this.message = message;
    this.obj = obj;
    }

}