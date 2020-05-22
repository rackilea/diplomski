public class Response{

    @SerializedName("response")
    private Response response;

    @SerializedName("code")
    private String code;

    @SerializedName("success")
    private boolean success;

    @SerializedName("customers")
    private List<Customers> customers;

    public void setResponse(Response response){
        this.response = response;
    }

    public Response getResponse(){
        return response;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public boolean isSuccess(){
        return success;
    }

    public void setCustomers(List<Customers> customers){
        this.customers = customers;
    }

    public List<Customers> getCustomers(){
        return customers;
    }
}