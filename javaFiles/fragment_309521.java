ArrayList<String> spinnerArray = new ArrayList<String>()   

public ArrayList<String> getList() {

 JSONArray jArray = new JSONArray(jsonArrayForSection);
    for (int i = 0; i<jArray.length(); i++) {
        JSONObject j = jArray.getJSONObject(i);
        sectiondata = j.optString("Section_Name");
        spinnerArray.add(sectiondata);
    }
      return spinnerArray;
}