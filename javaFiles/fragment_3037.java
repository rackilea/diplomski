private JSONObject putJson() throws Exception {
    JSONObject result = null;
    try {
        JSONObject json = new JSONObject();

        // Add your data
        json.put("model", "model/50a2eac63c19200bd1000008");
        JSONObject input_data = new JSONObject();
        input_data.put("000001", 3);
        json.put("input_data", input_data);

        Webb webb = Webb.create();
        result = webb
                .post("https://bigml.io/andromeda/prediction?username=alfred;api_key=79138a622755a2383660347f895444b1eb927730")
                .body(json)
                .ensureSuccess()
                .asJsonObject()
                .getBody();

    } catch (JSONException e) {
        // should not happen
        // Log.d("Error here", "Error is here",e);
    } catch (WebbException e) {
        // carries the real exception
    }
    return result;
}