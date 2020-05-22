@RequestMapping(value = "/toggle")
public @ResponseBody String sendCommand(@RequestBody String json){
   final YourObject yourObject = mapJsonToObject(json);
   final String ip = yourObject.getIp();
//body
}