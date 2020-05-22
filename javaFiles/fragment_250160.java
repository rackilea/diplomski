ArrayList<PromesaPago> result = new ArrayList<>();
 try {
            JSONObject object =new JSONObject(json);
            result = gson.fromJson(posts.getString("promesas"), new TypeToken<List<PromesaPago>>(){}.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }