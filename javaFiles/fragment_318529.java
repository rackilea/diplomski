@RequestMapping(value = "/loadAllUsers", method = RequestMethod.POST)
@ResponseBody
public String loadAllUsers(@RequestBody String paramsJsonStr,ModelMap model,HttpServletRequest request, HttpServletResponse response) throws IOException {

String responseJSONStr = null;
ResponseJSON responseJSON = new ResponseJSON(); //Custom class for sending response data 

try {
     .....
     .....
     List<User> users = this.loadAllUsers();
     responseJSON.setIsSuccessful(true);
     responseJSON.setData(schemas);
}catch (CustomException e) {
     e.printStackTrace();
     response.setStatus(e.getErrorCode()); //http failure status code as per respective error
     responseJSON.setIsSuccessful(false);
     responseJSON.setMessage(e.getErrorMessage());
}

 responseJSONStr = JSONUtilities.toJson(responseJSON);
 return responseJSONStr;
}