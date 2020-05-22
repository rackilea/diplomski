private class ReadMessages extends AsyncTask<Void, Void, Integer> {
    HttpURLConnection conn;
    String ansver, bfr_st;
    JSONArray JsonArray;

    @Override
    protected Integer doInBackground(Void... params) {
        try {
        String post_url = server_name +"/chat.php?action=select";
        conn = (HttpURLConnection) new URL(post_url).openConnection();
        conn.setReadTimeout(10000); 
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setDoInput(true);
        conn.connect();

        InputStream is = conn.getInputStream(); //канал
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8")); //буфер
        StringBuilder sb = new StringBuilder(); //сборщик строки
        while ((bfr_st = br.readLine()) != null) {
            sb.append(bfr_st); //получили массив в виде string
        }

        String json_bum = sb.toString(); 
        JsonArray = new JSONArray(json_bum); //преобразовали string обратно в массив

        for (int i=0; i<JsonArray.length(); i++) { 
             jsonObject = JsonArray.getJSONObject(i); //вынули все обьекты
        }
            is.close();
            br.close();

            } catch (Exception e) { 

            } finally { 

                conn.disconnect();
            }
            return null;

        }

        @Override
        protected void onPostExecute(String result) {
           tv_number.setText("Номер     - " + jsonObject.getInt("_id") + 
                  "\n"
                    + "Автор -      " + jsonObject.getString("author") +
                    "\n" 
                    + "Адресат     - " + jsonObject.getString("client") +
                    "\n"
                    + "Время -      " + jsonObject.getLong("data") +
                    "\n"
                    + "Текст - "      + jsonObject.getString("text") +
                    "\n");
    }