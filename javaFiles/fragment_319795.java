HashMap<String,String> hashOut = new HashMap<String,String>();
    String input = "{\"others\":[    {        \"id\":\"1\",        \"caption\":\"test\"    },    {        \"id\":\"2\",        \"caption\":\"self\"    },    {        \"id\":\"2\",        \"caption\":\"self\"    },    {        \"id\":\"1\",        \"caption\":\"test\"    }],\"quantity\":[    {        \"id\":\"1\",        \"caption\":\"self1\"    },    {        \"id\":\"1\",        \"caption\":\"self1\"    }]}";
    JSONObject jsonObj = new JSONObject(input);
    Iterator it = jsonObj.keys();

    while (it.hasNext()) {
        hashOut.clear();
        JSONArray jsInner = (JSONArray) jsonObj.getJSONArray((String) it.next());
        for (int i=0;i<jsInner.length();i++) {
            JSONObject jo = new JSONObject(jsInner.get(i).toString());
            hashOut.put((String)jo.get("id"), (String)jo.get("caption"));
        }
        System.out.println(hashOut);
    }