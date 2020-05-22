GET /test?state=CA

->

@RequestMapping(value = "/test", method = GET)
public String test(@RequestParam String state){
    // ...
}