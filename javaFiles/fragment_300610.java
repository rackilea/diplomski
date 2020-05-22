@RequestMapping(value = "/test", method = RequestMethod.POST)
public String test(@RequestBody IncomingRequestBody requestBody) {
    System.out.println(requestBody.getPropertyFiles());
    // other statement
    return "ok good";
}