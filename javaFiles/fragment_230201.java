@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @ExceptionHandler(SQLException.class)  
    public MyCustomException handleSQLException(SQLException exception) {
        MyCustomException ex = new MyCustomException();
        ex.setExceptionCode("MyCode");
        ex.setExceptionDescription(exception.getMessage());     
        return ex;
    }

}