public class CreateWorkOrderItemResponse {
    private String responseCode = null;
    private ArrayList<String> errorList = new ArrayList<String>();

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void addError(String error) {
        errorList.add(error);
    }

    public void setErrorList(ArrayList<String> errorList) {
        this.errorList = errorList;
    }

    @XmlElementWrapper(name="error_list") 
    @XmlElement(name="error")
    public ArrayList<String> getErrorList() {
        return errorList;
    }
}