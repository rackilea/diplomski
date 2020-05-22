private class ReadFile extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
       HttpURLConnection conn = null;
        try {
            URL url = new URL("http://www.free-map.org.uk/course/mad/ws/get.php?username=user002&format=csv");
            conn = (HttpURLConnection) url.openConnection();
            InputStream in = conn.getInputStream();
            if(conn.getResponseCode() == 200)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    String[] comps = inputLine.split(",");
                    if (comps.length == 5) {
                        OverlayItem currentItem = new OverlayItem(comps[0], comps[2], new GeoPoint(Double.parseDouble(comps[4]), Double.parseDouble(comps[3])));
                        pois.addItem(currentItem);
                    }
                }
            }

        }catch (Exception e){
            Log.e("Error, e.toString());
        }
        finally
        {
            if(conn!=null)
                conn.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {

    }

    @Override
    protected void onPreExecute() {}
}