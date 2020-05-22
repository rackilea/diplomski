private class Async extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //createDialog();
        }

        @Override
        protected String doInBackground(Void... params) {
            StringBuffer response = null;
            try {
                URL url = new URL(Api.BASE_URL + "username" + Utils.exchange + "password" + Utils.code);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                // optional default is GET
                con.setRequestMethod("GET");
                //add request header
                con.setRequestProperty("X-Authorization-Token", prefs1.getString("auth_token", ""));
                int responseCode = con.getResponseCode();
                if (responseCode == 401) {
                    return "401";
                }
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                //print result
                System.out.println(response.toString());
            } catch (Exception er) {
                System.out.println(TAG + er);
            }
            try {
                return response.toString();
            } catch (Exception e) {
                return "";
            }
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e(TAG, s);
            //    dialog.cancel();
        }
    }