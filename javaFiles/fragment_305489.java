JSONTokener jk = ...; // whatever you're currently doing.

// Probably a loop here around the below...

Object o = jk.nextValue();
if(o instanceof JSONObject){
  JSONObject jo = (JSONObject)o;
  // Do something with jo.
}else if(o instanceof JSONArray){
  JSONArray ja = (JSONArray)o;
  // Do something with ja.
}else{
  // Is null or another type.  (Maybe do something?)
}