JSONArray arr = response.getJSONArray("pietanze");
for (int i = 0; i < arr.length(); i++) {
    JSONObject jsonObject = arr.getJSONObject(i);

    if(jsonObject.has("PANINI")) {
        JSONArray paniniJsonArray = jsonObject.getJSONArray("PANINI");
        List<Panini> listPanini = new ArrayList<>();

        for (int j = 0; j < paniniJsonArray.length(); j++) {
            Panini panini = new Panini();
            panini.setId(paniniJsonArray.getJSONObject(j).getString("id"));
            panini.setNomepietanza(paniniJsonArray.getJSONObject(j).getString("nomepietanza"));
            panini.setPrezzo(paniniJsonArray.getJSONObject(j).getString("prezzo"));
            listPanini.add(panini);
        }
        expandableListDetail.put(arr.getJSONObject(i).getString("tipopietanza"), listPanini);
    }
}