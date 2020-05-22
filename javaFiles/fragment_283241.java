private void getStream(String urlString) {
        URL url = null;
        HttpURLConnection urlConnection = null;
        InputStream is = null;

        try {
            url = new URL(urlString);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            Log.i("Status", "Connection opened");

            BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            Log.i("Status", "XML loaded into string");

        } catch (Exception e) {
            Log.e("Error", e.getMessage().toString());
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
                Log.i("Status", "Connection disconnected");
            }
        }
    }