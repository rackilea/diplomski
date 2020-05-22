List <String> links = getLinks();
    JSONArray array = new JSONArray();
    for (String link : links)
            array.put(link);

    JSONObject obj = new JSONObject();
    //put id, code, type...
    obj.put("images", array);