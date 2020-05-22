if ((empList != null) && (!empList.isEmpty())) {

   JSONObject obj = new JSONObject();
   obj.put("status","success");
   obj.put("name",new JSONArray());
   obj.put("id",new JSONArray());
   for(Employee emp : empList){
     obj.get("name") .put(emp.name);
     obj.get("id") .put(emp.id);
     responseJSON = obj;
    }
}