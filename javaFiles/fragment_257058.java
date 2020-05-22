class GetMarkers extends AsyncTask<User, Void, JSONArray>{

        User markeruser = new User(userLocalStore.getLoggedInUser().username, userLocalStore.getLoggedInUser().password);
        JSONArray jsonarray = null;
        @Override
        protected JSONArray doInBackground(User... params) {

            try {
                URL url = new URL("https://someurl.com/file.php");
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                String param = "Username="+markeruser.username+"&pw="+markeruser.password;
                OutputStream out = conn.getOutputStream();
                DataOutputStream dataOut = new DataOutputStream(out);
                dataOut.writeBytes(param.trim());

                InputStream in = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                StringBuilder builder = new StringBuilder();
                while((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close();
                String response = builder.toString();

                jsonarray = new JSONArray(response);
            }

            catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return jsonarray;
        }

        @Override
        protected void onPostExecute(JSONArray jsonarray) {

            try {

                for(int i=0; i<jsonarray.length(); i++){
                    JSONObject obj = jsonarray.getJSONObject(i);

                    String PT = obj.getString("NUMBER");
                    Double LAT = obj.getDouble("LATITUDE");
                    Double LNG = obj.getDouble("LONGITUDE");
                    LatLng position = new LatLng(LAT, LNG);

                    String title = "PT: " + PT;

                    googleMap.addMarker(new MarkerOptions().position(position).title(title).icon(BitmapDescriptorFactory.fromResource(R.drawable.red)));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }