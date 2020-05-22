try {
        JSONObject jsonObject = new JSONObject("YOUR_RESPOSE");
        JSONArray data = jsonObject.getJSONArray("data");
        Type listType = new TypeToken<ArrayList<pojo>>() {
        }.getType();
        ArrayList<pojo>  list =new Gson().fromJson(data.toString(), listType);

    } catch (JSONException e) {
        e.printStackTrace();
    }