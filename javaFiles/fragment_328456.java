@ExceptionHandler(Customized4ExceptionHandler.class)
@ResponseStatus(value=HttpStatus.BAD_REQUEST) 
@ResponseBody
public String handleCustomized4Exception(
    Customized4ExceptionHandler ex) {

    // return "zzzzzzz"
    return ex.getSpecialMsg();

}