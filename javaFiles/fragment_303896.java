JSONArray result = response.getJSONArray("result");
for (int i = 0; i < result.length(); i++) {
    JSONObject jsonObject = result.getJSONObject(i);

    String name = jsonObject.getString("name");
    String phone = jsonObject.getString("phone");
    String email = jsonObject.getString("email");

    // Each time create a new instance and then save the value.
    ModUpdateAdapter modUpdateAdapter = new ModUpdateAdapter();

    modUpdateAdapter.setName(name);
    modUpdateAdapter.setPhone(phone);
    modUpdateAdapter.setEmail(email);
    arrayList.add(modUpdateAdapter);
}