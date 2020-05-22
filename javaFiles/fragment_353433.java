@ExceptionHandler(Exception.class)
@ResponseBody
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public String handleException(Exception e) {
    return "return error object instead";
}