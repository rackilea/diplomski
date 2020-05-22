JSONObject obj = new JSONObject();
    obj.put("name", "mkyong.com");
    obj.put("age", new Integer(100));

    JSONArray list = new JSONArray();
    JSONObject obj2 = new JSONObject();
    JSONObject obj3 = new JSONObject();
    obj3.put("msg 1","1");
    obj3.put("msg 2","2");
    obj3.put("msg 3","3");
    obj2.put("obj3",obj3);
    list.put(obj2);
    obj.put("messages", list);