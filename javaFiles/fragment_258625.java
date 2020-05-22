@RequestMapping(
        value = "/test",
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/json")
@ResponseBody
public JsonNode getStuff(@RequestHeader HttpHeaders header,
                                 @RequestBody Data payload,
                                 BindingResult bindingResult) {
    validator.validate(payload, bindingResult);
    if(bindingResult.hasErrors()) {
        throw new InvalidRequestException("The request is incorrect", bindingResult);
    }
    /* doing other stuff */
}