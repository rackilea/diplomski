String inp = "{\"key1\": \"value\", \"key2\": {\"key\": \"value\"}}";
JSONObject x = new JSONObject(inp);
System.out.println(x);//the toString method gives the object back
System.out.println(x.get("key2"));//you can get any key's value by passsing its key
//setting date here:
x.putOpt("date", "26/09/2017");
System.out.println(x);//you can return the object by doing a toString() of the JSONObject.