public class GetDataFromServerIntoTextView extends AsyncTask<Void, Void,String> 
          {
        public Context context;

        public GetDataFromServerIntoTextView(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {

            String strUrl = "https://api.myjson.com/bins/1cuzhn";
            String data = "";
            InputStream iStream = null;
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(strUrl);

                // Creating an http connection to communicate with url
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();

                // Reading data from url
                iStream = urlConnection.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
                StringBuffer sb = new StringBuffer();

                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                data = sb.toString();

                br.close();

            } catch (Exception e) {
                Log.d(TAG, "Exception while downloading url " + e.toString());
            } finally {
                try {
                    iStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                urlConnection.disconnect();
            }
            return data;
        }


        @Override
        protected void onPostExecute(String data) {
            super.onPostExecute(data);
            try {
                if (data != null) {
                    JSONArray jsonArray = new JSONArray(data);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        // Here is your all data of distance and time
                        Log.e(TAG, "distance " + jsonObject.get("distance"));
                        Log.e(TAG, "time " + jsonObject.get("time"));

                    }

                } else {
                    Log.e(TAG, "onPostExecute: null json object");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }