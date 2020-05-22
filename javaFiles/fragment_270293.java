String js = response.getBody().toString();
    System.out.println(js.toString());


    JSONObject jObject = new JSONObject(js); // json
    System.out.print("hello");
    JSONArray data1 = jObject.getJSONArray("results");

    for(int i = 0; i < data1.length; i++)
    {
        JSONObject jsonObject = data1.getJSONObject(i);
        String projectn ame = jsonObject.getString("tagging_id");                                                                       
        System.out.print(projectname);

        JSONArray tagArray = jsonObject.getJsonArray("tags");

        for(int j = 0; j < tagArray.length; j++)
        {
             JSONObject tagObject = tagArray.getJSON(j);
             System.out.println("Tag == " + tagObject.getString("tag"));
        }

    }