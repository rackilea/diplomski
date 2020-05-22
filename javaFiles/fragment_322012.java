protected Void doInBackground(LatLng... params) {
        Log.d("Maps", "background");
        String lat = Double.toString(params[0].latitude);
        String lng = Double.toString(params[0].longitude);
        String strUrl = "http://yourdomain.com/save.php";                   
        URL url = null;
        try {
            url = new URL(strUrl);
            Log.d("Maps", "url fetch");
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            Log.d("Maps", "opened");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    connection.getOutputStream());

            outputStreamWriter.write("lat=" + lat + "&lng="+lng);               
            Log.d("Maps", "wrote");
            outputStreamWriter.flush();
            outputStreamWriter.close();

            InputStream iStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";

            while( (line = reader.readLine()) != null){
                sb.append(line);
            }

            reader.close();
            iStream.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }