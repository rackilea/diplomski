/**
 * HTTP_STATUS - 500 -Service Unavailable.
 * 
 * @param exception
 *            Catches the following: MyException
 * @return
 */
@ExceptionHandler({ MyException.class})
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@ResponseBody
public static ResponseEntity<?> handleConnectionErrorResponse(MyException exception) {
    return new ResponseEntity<String>("Some error occurred at server", HttpStatus.INTERNAL_SERVER_ERROR);
}