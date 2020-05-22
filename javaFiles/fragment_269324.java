@ControllerAdvice
public class Foo extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<MyCustomErrorBody> handleControllerException(HttpServletRequest request, MyException ex) {

        // Build your error response here and return it. 
        // Create a class that will represent the json error body 
        // and pass it as body and jackson will deserialize it for 
        // you into json automatically.

        final MyCustomErrorBody body = new MyCustomErrorBody(false, ex.getMessage(), "0.97", "Patient_Responsibility")

        return ResponseEntity.unprocessableEntity().body(myCustomErrorBody).build();
    }
}


public class MyCustomErrorBody {

    private boolean status;
    private String errorMessage;
    private String version;
    private String coreName;

    // constructor and getters setters ommitted

}