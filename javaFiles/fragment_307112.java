@HandleExceptionSet(exceptionSet = {
        @HandleException(exception = ArithmeticException.class),
        @HandleException(exception = NullPointerException.class),
        @HandleException(exception = EntityNotFoundException.class)
})
public void method()throws Throwable {
    throw new EntityNotFoundException("EVENT1", "ERR1", "Entity Not Found", "Right", "Wrong");
}