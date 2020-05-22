void getRetrofitArray() {
    String BASE_URL = "http://192.168.0.18:8080/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RestAPI service = retrofit.create(RestAPI.class);

    Call<JsonArray> jsonCall = service.getUsers();

    jsonCall.enqueue(new Callback<JsonArray>() {
        @Override
        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                String userData = response.body().toString();
                listOfMaps = new ArrayList<Map<String, String>>();
                JSONArray temp = new JSONArray(userData);

        for (int i = 0; i < temp.length(); i++) {
            JSONObject row = (JSONObject) temp.get(i);
            int id = row.getInt("id");
            String name = row.getString("name");
            String username = row.getString("username");
            String password = row.getString("password");
            String photo = row.getString("photo");

            HashMap<String, String> user_exist = new HashMap<String, String>();
            user_exist.put("id",String.valueOf("id"));
            user_exist.put("name",name);
            user_exist.put("username",username);
            user_exist.put("password",password);
            user_exist.put("photo",photo);
            listOfMaps.add(user_exist);

        }





        }

        @Override
        public void onFailure(Call<JsonArray> call, Throwable t) {

        }
    });
}