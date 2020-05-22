JSONObject jsonObject= new JSONObject();
 try{
     jsonObject.put("m2m:ae", "xmlns:m2m=\"http://www.onem2m.org/xml/protocols\" rn=\"MY_SENSOR");
     jsonObject.put("api", "app-sensor");
     jsonObject.put("lbl", "Type/sensor Category/temperature Location/home");
    jsonObject.put("ff", "false");
    }catch(JSONException e){
    }