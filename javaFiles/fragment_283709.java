JSONObject mainObj= new JSONObject(yourJSON);
 String resultCode= mainObj.get("resultCode");
 String message= mainObj.get("message");
 String result= mainObj.get("result");
 JSONObject dataObj = mainObj.get("data");
 JSONArray jsonArray = (JSONArray) dataObj.get("videos");
 for (int i = 0; i <jsonArray.length(); i++) {
   JSONObject obj= jsonArray.get(i);
   String videoId=obj.get("videoId");
   String videoUrl=obj.get("VideoUrl");
   String title=obj.get("title");
   String description=obj.get("description");
    System.out.println("videoId="+videoId   +"videoUrl="+videoUrl+"title=title"+"description="+description);        
}
 System.out.println("resultCode"+resultCode+"message"+message+"result"+result);