@Autowired
private ErrorAttributes errorAttributes;

@ExceptionHandler(MissingServletRequestParameterException.class)
public ResponseEntity<Map<String, Object>> handle(HttpServletRequest request, Exception exception) {
    RequestAttributes requestAttributes = new ServletRequestAttributes(request);
    Map body = this.errorAttributes.getErrorAttributes(requestAttributes,false);

    return new ResponseEntity<Map<String, Object>>(body, HttpStatus.BAD_REQUEST);
}