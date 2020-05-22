@RequestMapping(value = "/test", method = RequestMethod.POST)
@ResponseBody
public void test(@RequestParam(value = "i", required=false) Integer i) {
    if(i == null) {
        i = 10;
    }
    // ...
}