@RequestMapping(value = "/somepath", method = RequestMethod.POST)
@ResponseBody
public JsonResponse someMethod (HttpSession session)
{
 // play with session attributes
}