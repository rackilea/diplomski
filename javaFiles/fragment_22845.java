@ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
public onErr400(@RequestHeader(value="ETag", required=false) String ETag,
        UnsatisfiedServletRequestParameterException ex) {
    if(ETag == null) {
        // Ok the problem was ETag Header : give your informational message
    } else {
        // It is another error 400  : simply say request is incorrect or use ex
    }
}