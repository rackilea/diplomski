@RequestMapping(value = "/somepath", method = RequestMethod.POST)
@ResponseBody
public JsonResponse someMethod (HttpServletRequest request)
{
  Session session = request.getSession();
  // You are playin with the same session attributes.
}