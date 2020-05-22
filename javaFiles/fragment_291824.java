@Override
protected void onPostExecute(String JSONResponse) {
    Bundle bundle = new Bundle();
    bundle.putString("key_json_response", result); //put the response in a Bundle
    listener.onTaskComplete(bundle);
}

// .....
public void updateUI(Object result) {
   Bundle bundle = (Bundle)result;
   if(bundle.containsKey("key_json_response")){
     String json = bundle.getString("key_json_response");
     // process json
   } else if(bundle.containsKey("key_another_response")){
     // process another response
   } 
}