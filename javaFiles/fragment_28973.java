List<Person> personList = new ArrayList<>();
    JSONArray jsonArr;
    try {
        jsonArr = new JSONArray(response);
        for(int i=0;i<jsonArr.length();i++){
            JSONObject c = jsonArr.getJSONObject(i);
            String service_group = c.getString("sgroup");
            String service = c.getString("service");
            String value = c.getString("value");
            String updated_at = c.getString("updated_at");

            Person p = new Person(service_group, service, value, updated_at);

            personList.add(p);
        }
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }