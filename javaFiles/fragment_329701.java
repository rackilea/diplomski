JSONObject jsonObj = new JSONObject(JSON_DATA);

        // here participants is jsonObject, not jsonArray
        JSONObject participants = jsonObj.getJSONObject("participants");

        // this jsonObject participants has five key-value pairs.
        // so iterate through keys and fetch values (These values are also another
        // jsonObject)
        Iterator<String> key = participants.keys();
        while (key.hasNext()) {
            JSONObject person = participants.getJSONObject(key.next());
           // value of key studentNum is string type
            System.out.println(person.getString("studentNum"));
        }