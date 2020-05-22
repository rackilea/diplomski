//Once again, no magic
public class ValidationObject {

    //This will be your property names
    private String field, error;

    public ValidationObject(String field, String error){
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}