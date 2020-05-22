public Data loadDatas(String url) {
    final Data data = new Data();
    client.post(url, new JsonHttpResponseHandler() {

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        super.onSuccess(statusCode, headers, response);
            try  {
                int st = response.getInt("st");
                int timest = response.getInt("t");
                Date dateTime = new Date(timest);
                String dateString = (String) DateFormat.format("dd:MM:yyyy \t\t  hh:mm:ss", dateTime);
                double val = response.getDouble("v");
                data.setDate(dateString);
                data.setValue(val);
                data.setState(st);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    });
    return data;
}