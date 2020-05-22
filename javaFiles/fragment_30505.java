JSONObject jObj = new JSONObject(request.getParameter("mydata")); // this parses the json
Iterator it = jObj.keys(); //gets all the keys

while(it.hasNext())
{
    String key = it.next(); // get key
    Object o = jObj.get(key); // get value
    session.putValue(key, o); // store in session
}