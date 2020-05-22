jObject = new JSONObject(byteArrayOutputStream.toString());

 JSONObject jObjectResult = jObject.getJSONObject("data");
 JSONArray jArray = jObjectResult.getJSONArray("mainScreen");
 myTasks = new ArrayList<Tasks>();
 mainObjs = new ArrayList<MainScreenObject>();
 for (int i = 0; i < jArray.length(); i++) {

  JSONObject jobj = jArray.getJSONObject(i)
  JSONObject jAddi= jobj.getJSONObject("addi_info");
  JSONArray tasks = jAddi.getJSONArray("tasks");