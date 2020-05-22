String namespace = "http://tempuri.org/" ;
     String soapAction = "http://tempuri.org/MyMethod";
     String methodName = "MyMethod";
     String url = "http://192.168.1.2:8686/WebService/MyWebService.asmx" ; // my local or valid ip for webservice location 
     SoapObject request =  new SoapObject(namespace, methodName);

     // your webservice argument
     String username = "your username";
     PropertyInfo usernameProp = new PropertyInfo();
     usernameProp.setName("username");
     usernameProp.setValue(username);
     usernameProp.setType(String.class);
     request.addProperty(usernameProp);

     String pass = "your password";
     PropertyInfo passProp = new PropertyInfo();
     passProp.setName("password");
     passProp.setValue(pass);
     passProp.setType(String.class);
     request.addProperty(passProp);

    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.dotNet = true;
    envelope.setOutputSoapObject(request);
    HttpTransportSE androidHttpTransport = new HttpTransportSE(url);
    androidHttpTransport.call(soapAction, envelope);
    SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
    String json = response.toString();
    json = "{\"data\":" + json + "}";
    JSONObject mainJson = new JSONObject(json);
    JSONArray jsonArray = mainJson.getJSONArray("data");
    ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject objJson = jsonArray.getJSONObject(i);
        HashMap<String , String> map = new HashMap();
        map.put("UserID" , objJson.getString("UserID")); 
        map.put("Username" , objJson.getString("Username")); 
        map.put("Token" , objJson.getString("Token")); 
        list.add(map)
    }

    //use your list