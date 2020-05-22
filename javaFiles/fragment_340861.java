@RequestMapping(value="/new")
@ResponseBody
public String createDispatch(@RequestParam(value="p1") String p1) {
    Success ds = new Success();
    ObjectMapper mapper = new ObjectMapper();    
    return mapper.writeValueAsString(ds);
}      

@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public String handleAnyException(Exception exception) {
    return formatExceptionAsJson(exception);
}