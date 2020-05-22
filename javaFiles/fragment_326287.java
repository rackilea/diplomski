@Override
public void doPut(HttpServletRequest request, HttpServletResponse response) {
  // this parses the incoming JSON from the body.
  JSONObject jObj = new JSONObject(getBody(request));

  Iterator<String> it = jObj.keys();

  while(it.hasNext())
  {
    String key = it.next(); // get key
    Object o = jObj.get(key); // get value
    System.out.println(key + " : " +  o); // print the key and value
  }
  ...