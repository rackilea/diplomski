String jsonString = request.getParameter("jsonParemeter");
 Gson gson = new Gson();
 Map fromJsonMap = gson.fromJson(jsonString, HashMap.class);

 Object object = fromJsonMap.get("title");
 if (object instanceof Collection) {
  // then is it's your array
 }
 else {
   // it's not
 }