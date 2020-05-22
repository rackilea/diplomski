if(json != null){
    for (int i = 0; i < json.length(); i++) {

            try {
                JSONObject c = json.getJSONObject(i);
                String parsed_results_formatted_address = c
                        .getString("formatted_address");
arrfortextviews.add(parsed_results_formatted_address);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
}