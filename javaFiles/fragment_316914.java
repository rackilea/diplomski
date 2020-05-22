StringBuilder sb = new StringBuilder();
 BufferedReader br = req.getReader();
 String str = null;
 while ((str = br.readLine()) != null) {
     sb.append(str);
 }

 String json = sb.toString();


 JsonReader jsonReader = Json.createReader(new StringReader(json));
 JsonObject jsonObject = jsonReader.readObject();
 jsonReader.close();

 // an object with three fields.
 User u = new User(jsonObject.getString("email"), "10010099", jsonObject.getString("pass"));