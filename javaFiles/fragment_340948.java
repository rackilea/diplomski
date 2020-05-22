JSONObject parentObject = new JSONObject(finalJSON);


JSONArray userArray = parentObject
                .getJSONObject("reply")
                .getJSONArray("users");

JSONObject finalObject = userArray.getJSONObject(0);