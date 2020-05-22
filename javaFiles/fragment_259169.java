@RequestMapping(value = "/{blabla}", method = RequestMethod.POST)
public void post(HttpServletRequest request) {
    String X-CAF-MSGID = request.getHeader("X-CAF-MSGID");
    if(X-CAF-MSGID == null) {
        // Your JSON Error Handling
    } else {
        // Your Processing
    }
}