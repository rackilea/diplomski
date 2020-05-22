public class MyForm {

    private String personId;
    private String addressId;
    private HttpRequest request;

    public MyForm() {

    }

    @PathParam("personId")
    public void setPersonId(String personId) {
         this.personId = personId;
    }

    @PathParam("addressId")
    public void setAddressId(String addressId) {
         this.addressId = addressId;
    }

    public HttpRequest getRequest() {
        return request;
    }

    @Context
    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return String.format("MyForm: [personId: '%s', addressId: '%s', request: '%s']", 
                this.personId, this.addressId, this.request);
    }
}