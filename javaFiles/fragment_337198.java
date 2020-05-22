import org.codehaus.jackson.map.ObjectMapper;
  import org.json.JSONException;
  import org.json.JSONObject; 


HttpServletRequest request = ServletActionContext.getRequest();
Vehicles vehicles;
String jsonData = request.getParameter("JsonData");
jsonData = jsonData.substring(13, jsonData.length()-2);
ObjectMapper mapper = new ObjectMapper();
try{
    vehicles= mapper.readValue(jsonData, Vehicles.class);
}
catch (Exception e) {
    e.printStackTrace();
}