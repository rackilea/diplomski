@RequestMapping(value = "/addPerson",
                method = RequestMethod.POST,
                headers = {"Content-type=application/json"})
@ResponseBody
public JsonResponse addPerson(@RequestBody Person person) {
  logger.debug(person.toString());
  return new JsonResponse("OK","");
}