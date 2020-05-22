@RequestMapping(value = "/helloworld", method = RequestMethod.POST)
@ResponseBody
public JsonResponse sayHello(@RequestBody String reqestString ,HttpSession sessionObj)
{
  sessionObj.setAttribute("message" , "It is simple to get access to HttpSession ");
  return jsonResponse;
}