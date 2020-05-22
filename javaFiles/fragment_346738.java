int attempts=5;
boolean flag=false;
while(attempts-- > 0){
  try{
   uRL = new URL(URLString);
   connection = (HttpURLConnection) uRL.openConnection();    
   connection.setRequestMethod("GET");    
   connection.setRequestProperty("User-Agent", USER_AGENT);    
   responseCode = connection.getResponseCode();
   flag=ture;
    break;
  }catch(Exception e){
      e.printStackTrace();
      continue;
    }
}


 if(flag){
     // mean request executed successfully 
     // don't throw exception, unless you want to break the current flow of execution
    }