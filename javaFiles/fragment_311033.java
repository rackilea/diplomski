@RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
@ResponseBody
@IpRestricted
public void download(@PathVariable("id") String id) {
   ...
}