JSONObject jsonObj = new JSONObject("{\"name\":
                     {\"fname\" : \"An\", \"mname\" : \"der\", \"lname\" : \"Decke\"}}");

// get embedded "name" JSONObject
JSONObject name = jsonObj.getJSONObject("name");

System.out.println(name.getString("fname") + " "
                 + name.getString("mname") + " "
                 + name.getString("lname")); // An der Decke