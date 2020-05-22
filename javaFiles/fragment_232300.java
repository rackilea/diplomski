@Root(name = "Errors")
public class ErrorResponse {

    @ElementList(inline = true)
    List<Error> errors;

    public ErrorResponse() {
        // no arg constructor
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return this.errors;
    }
}