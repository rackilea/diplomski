JSONArray jCastArr = jObj.getJSONArray("abridged_cast");
ArrayList<Cast> castList= new ArrayList<Cast>();

for (int i=0; i < jCastArr.length(); i++) {
    Cast person = new Cast();  // create a new object here
    JSONObject jpersonObj = jCastArr.getJSONObject(i);

    person.castId = (String) jpersonObj.getString("id");
    person.castFullName = (String) jpersonObj.getString("name");

    castList.add(person);
}
details.castList = castList;