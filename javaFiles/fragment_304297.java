@RequestMapping("/saveChild.json")
@ResponseBody
public Child saveChild(@RequestBody Child child) {
  // do something with child
  return child;
}