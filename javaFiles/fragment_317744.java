//You can use @RestController or @ResponseBody to send a response in JSON format 

@PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE)
public MOResponse receiveNotification(@RequestBody MO mo) {
    studentService.getStudent(mo);
    MOResponse moResponse = new MOResponse("S1000", "Success");
    return moResponse;
}