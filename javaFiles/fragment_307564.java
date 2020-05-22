@Controller
@RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET, produces="application/json")
@ResponseBody
public ResponseEntity<String> getHeartBeat() throws Exception {
    String curr_time = myService.getCurrentTime();      
    return Util.getResponse(curr_time, HttpStatus.OK);
}