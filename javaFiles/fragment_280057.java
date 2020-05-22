JSONArray empArray = object.getJSONArray("employee");

for (int i = 0; i < empArray.length(); i++) {

  JSONObject currentobject = empArray.getJSONObject(i);
  String name = currentobject.getString("name");
  String email = currentobject.getString("email");

  Log.i("Name", ":" + name);
  Log.i("Email", ":" + email);

  JSONArray deptArry = currentobject.getJSONArray("department");

  for (int j = 0; j < deptArry.length(); j++) {

      Log.i("Dept", ":" + deptArry.get(j));
  }

}