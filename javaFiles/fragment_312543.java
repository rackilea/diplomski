JSONObject root = // however you get your root JSON object
        JSONArray posts = root.optJSONArray("posts");
        for(int i=0; i < posts.length(); i++){
            JSONObject post = posts.optJSONObject(i);
            int id = post.optInt("id");
            JSONArray categories = post.optJSONArray("categories");
            // etc.
        }