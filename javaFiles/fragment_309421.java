try
    {   
        String jsonString="";//your json string here
        JSONObject jObject= new JSONObject(jsonString).getJSONObject("categories");
        Iterator<String> keys = jObject.keys();
        while( keys.hasNext() )
        {
            String key = keys.next();
            Log.v("**********", "**********");
            Log.v("category key", key);
            JSONObject innerJObject = jObject.getJSONObject(key);
            Iterator<String> innerKeys = innerJObject.keys();
            while( innerKeys.hasNext() )
            {
                String innerKkey = keys.next();
                String value = innerJObject.getString(innerKkey);
                Log.v("key = "+key, "value = "+value);
            }
        }
    }
    catch (JSONException e)
    {   e.printStackTrace();    }