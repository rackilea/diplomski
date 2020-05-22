@CrossOrigin
@RequestMapping(value = "/{name}/run", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
String run(@RequestBody String input, @PathVariable("name") String name, @RequestParam Map<String, String> params) {
    Validate.notEmpty(input, "The request body must contain an not empty text");
    return runProcessor(input, name, params);
}