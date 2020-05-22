JSONObject[] check = new JSONObject[0];

    JSONObject g = new JSONObject();
    g.put("test", check);

    //System.out.println(((List<JSONObject>) g.get("test")).size());
    System.out.println(((JSONObject[]) g.get("test")).length);