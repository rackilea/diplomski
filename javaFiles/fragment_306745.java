RestClient client=new RestClient(Webservices.student_details);
JSONObject obj=new JSONObject();
obj.put("StudentId",preferences.getStudentId());
client.AddParam("",obj.toString());
client.Execute(RequestMethod.GET);
String response=client.getResponse();