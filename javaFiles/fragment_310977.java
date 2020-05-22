public void parseJson(){

    // Your JSON
    String result = "[\n" +
            "  \"{\\\"zone\\\":\\\"Tunis\\\",\\\"description\\\":\\\"le DAB fonctionne correctement.\\\",\\\"id_DAB\\\":22,\\\"etat\\\":\\\"En marche\\\",\\\"Libelle_DAB\\\":\\\"\\\"}\",\n" +
            "  \"{\\\"zone\\\":\\\"Tunis\\\",\\\"description\\\":\\\"le DAB fonctionne correctement.\\\",\\\"id_DAB\\\":26,\\\"etat\\\":\\\"En marche\\\",\\\"Libelle_DAB\\\":\\\"ooo\\\"}\",\n" +
            "  \"{\\\"zone\\\":\\\"Tunis\\\",\\\"description\\\":\\\"le DAB fonctionne correctement.\\\",\\\"id_DAB\\\":27,\\\"etat\\\":\\\"En marche\\\",\\\"Libelle_DAB\\\":\\\"\\\"}\",\n" +
            "  \"{\\\"zone\\\":\\\"Tunis\\\",\\\"description\\\":\\\"le DAB fonctionne correctement.\\\",\\\"id_DAB\\\":6660,\\\"etat\\\":\\\"En marche\\\",\\\"Libelle_DAB\\\":\\\"yyy\\\"}\"\n" +
            "]";

    String response = result.toString();

    try {
        JSONArray jArray = new JSONArray(response);

        for (int i = 0; i < jArray.length(); i++) {
            String string = jArray.getString(i);
            Log.i("try jaaray ob ", string.toString());

            JSONObject json_data = new JSONObject(string);
            int id = json_data.getInt("id_DAB");
            String libdab = json_data.getString("Libelle_DAB");
            String etat = json_data.getString("etat");
            String des= json_data.getString("description");
            String zone= json_data.getString("zone");

            Log.d("Success", "id: " + id + "\nlibdab: " + libdab + "\netat: " + etat +
            "\ndes: " + des + "\nzone: " + zone);
        }
    } catch (JSONException e) {
        Log.e("ERROR", "ERROR IN CODE: " + e.toString());
        e.printStackTrace();
    }
}