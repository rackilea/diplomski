GET /test?CA

->

@RequestMapping(value = "/test", method = GET)
public String test(@RequestParam Map<String, String> parameters){
    if (parameters.containsKey("CA")) {
        // ...
    }
}