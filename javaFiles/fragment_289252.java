private void parseJson(JSONArray response){
    try {

        if(userData==null){
            userData = new ArrayList<>();
        }else{
            userData.clear();
        }
        for (int i = 0; i < response.length(); i++) {
            JSONObject users = response.getJSONObject(i);

            String id = ("id: "+users.getString("id"));
            String name = ("Name: "+users.getString("name"));
            String username = ("Username: "+users.getString("username"));
            String email = ("Email: "+users.getString("email"));
            String address = parseAddress(users);
            String destination = parseCoordinates(users);
            String company = parseCompany(users);
            String phone = ("Phone: "+users.getString("phone"));
            String website = ("Website: "+users.getString("website"));
            String eta = get_time_to_travel(origin, destination, API, mode);

            UserData udata = new UserData(id, name, username, email, address, phone, website, company,eta);
            userData.add(udata);
        }

        if(adapter == null){
            adapter = new CustomAdapter(this, userData);
            recyclerView.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
}