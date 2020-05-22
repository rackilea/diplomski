public void sendData(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");

            for (int i = 0 ; i < result.length(); i++) {
                JSONObject obj = result.getJSONObject(i);
                String id = obj.getString("image"+i);
                image.add("http://192.168.12.252/"+id+"/profile.png");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
     adapter = new CustomAdapter(login_main.this,image);//set ur image array here
        viewPager.setAdapter(adapter);
    }