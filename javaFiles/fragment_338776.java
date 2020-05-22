String json = "{\"per_page\":50,\"total\":93,\"last_page\":2,\"stars\":[]}":

JSONObject jsonObject = new JSONObject (json);

JSONArray jsonArray  = jsonObect.getJSONArray("stars");

int perPage = jsonObject.getInt("per_page");