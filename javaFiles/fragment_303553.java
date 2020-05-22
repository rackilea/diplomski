GET /test/CA

->

@RequestMapping(value = "/test/{state}", method = GET)
public String test(@PathVariable String state){
    // ...
}