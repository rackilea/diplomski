ArrayList<String> username = new ArrayList<String>(); 
ArrayList<Double> weight = new ArrayList<Double>(); 

if (Username.equals(RegisteredUSer)) {
    JSONArray nameObject = msg.getJSONArray("NameList");

    for (int j = 0; j < nameObject.length(); j++) {
        JSONObject name = nameObject.getJSONObject(j);
        USername        = name.getString("FirstName");
        USerweight      = name.getString("Weight");
        Weight          = Double.parseDouble(USerweight);
        username.add(USername);
        weight.add(Weight);
    }
}