AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
                            @Override
                            protected Void doInBackground(Integer... integers) {

                                OkHttpClient client = new OkHttpClient();
                                Request request = new Request.Builder()
                                        .url("https://api.exchangeratesapi.io/latest?base=USD")
                                        .build();
                                try {
                                    Response response = client.newCall(request).execute();

                                    Log.d("Response", response.toString());
                                    JSONObject object = new JSONObject(response.body().string());

                                    JSONObject rates = new JSONObject((object.getJSONObject("rates")))


                                    Iterator<String> iter = rates.keys();
                                    while (iter.hasNext()) {
                                        String key = iter.next();
                    try {
                        Object value = rates.get(key);
                        Currency data = new Currency(value.getString("name"),value.getString("value"));
                        currency.add(data);
                    } catch (JSONException e) {
                        // Something went wrong!
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                System.out.println("End of content"+e);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            adapterCurrency.notifyDataSetChanged();
        }

        @Override
        protected void onPreExecute() {

        }
    };
    task.execute();
}