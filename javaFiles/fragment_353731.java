JSONObject jsonObject = new JSONObject(responseString);
    JSONObject projectsJsonObject = jsonObject.getJSONObject("response").getJSONObject("projects"); 
    if(projectsJsonObject.getJSONArray("project") == null)
    {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(projectsJsonObject.getJSONObject("project"));
        projectsJsonObject.put("project", jsonArray);

    }
    //Pass jsonObject to Gson