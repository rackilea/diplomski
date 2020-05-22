HttpGet httpget = new HttpGet(url);    
HttpResponse response;  
try {
   response = httpclient.execute(httpget);          
   HttpEntity entity = response.getEntity();             
   if (entity != null) {    
       InputStream instream = entity.getContent();
       result= convertStreamToString(instream);
       JSONObject json = new JSONObject(result);             
           JSONArray valArray = json.getJSONArray("data");

       for(int i=0;i<valArray.length();i++) {             

           String info = main_object.getString("message");
       }
       instream.close();
    }            
} 
catch (ClientProtocolException e) {             
    e.printStackTrace();
}