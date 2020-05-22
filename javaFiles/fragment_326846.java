@RequestMapping(value = "/test/{paraA}/{paraB}")
@ResponseBody
public BaseJsonRsp test(@PathVariable("paraA") String myParam, 
                        @PathVariable("paraB") String otherParam) {
    //doSomething
}