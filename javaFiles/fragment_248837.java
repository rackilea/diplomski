@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    new AsyncTask<Void, Void, Void>() {

        @Override
        protected Void doInBackground(Void... params) {
            String url = "http://192.168.1.132/Android/App/good.php";

            try {
                JSONArray data = new JSONArray(getJSONUrl(url));

                HashMap<String, String> map;

                for (int i = 0; i < data.length(); i++) {
                    JSONObject c = data.getJSONObject(i);

                    map = new HashMap<String, String>();
                    map.put("name", c.getString("name"));
                    map.put("artist", c.getString("artist"));
                    map.put("price", c.getString("price"));
                    map.put("image", c.getString("image"));

                    MyArrList.add(map);
                }

            } catch (JSONException e) {

                e.printStackTrace();
            } catch (Exception e) {

                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            final GridView gridView1 = (GridView) rootView.findViewById(R.id.store_home_gridview);
            gridView1.setAdapter(new ImageAdapter(getActivity(), MyArrList));

        }
    }.execute();
}