@ControllerAdvice("your.package")
public class CommonExceptionHandler {

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ResponseEntity<?> setNotFoundException(Exception exception) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        // this is sample map. you will make your custom model and you use exception parameter.
        Map<String, String> map = new HashMap<String, String>();
        map.put("timestamp", String.valueOf(new Date().getTime()));
        map.put("status", HttpStatus.NOT_FOUND.toString());
        map.put("error", "Not Found");
        map.put("exception", exception.getMessage());
        map.put("message", "Could not find data for owner: 1234");
        map.put("path", "/resource/owner/1234");
        map.put("errorId", "1000");

        String json = mapper.writeValueAsString(map);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
    }

}