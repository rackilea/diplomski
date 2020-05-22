JSONArray array = new JSONArray(bean2);
for(int i=0;i<array.length();i++){
    JSONObject object = array.getJSONObject(i);
    int id = object.getInt("id");
    int programs_idprograms = object.getInt("programs_idprograms");
    String description = object.getString("description");
    String idCourse = object.getString("idCourse");   
}