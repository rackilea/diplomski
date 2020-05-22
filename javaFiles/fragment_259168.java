@RequestMapping(value = "/{blabla}", method = RequestMethod.POST)
public void post(@RequestHeader(value="X-CAF-MSGID", required=false) String X-CAF-MSGID) {
    if(X-CAF-MSGID == null) {
        // Your JSON Error Handling
    } else {
        // Your Processing
    }
}