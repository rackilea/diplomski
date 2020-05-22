public class TempParams {
    /**
     * IsSuccess : true
     * ResponseObject : ["one","two","three","four","five"]
     */

    private boolean IsSuccess;
    private List<String> ResponseObject;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public List<String> getResponseObject() {
        return ResponseObject;
    }

    public void setResponseObject(List<String> ResponseObject) {
        this.ResponseObject = ResponseObject;
    }

}