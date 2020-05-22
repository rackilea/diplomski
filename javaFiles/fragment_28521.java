try {
       JSONObject jsonObj = api.GetCustomerDetails();
       JSONParser parser = new JSONParser();
       custTable = parser.parseCustomerDetails(jsonObj);
       Log.d("Customers: ", jsonObj.toString());
       jsonMainNode = jsonObj.optJSONArray("Value");
       for (int i = 0; i < jsonMainNode.length(); i++) {
          jsonChildNode = jsonMainNode.getJSONObject(i);
          name = jsonChildNode.optString("Naam");
       }
       //and then you can add the name to a List<String> which will contain all the values of each item in the Value JSON Array.
    } catch (Exception e) {
       // TODO Auto-generated catch block
       Log.d("AsyncLoadCustDetails", e.getMessage());

    }