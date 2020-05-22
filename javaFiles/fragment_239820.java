public JSONObject makeHttpRequest(String requestURL, JSONObject register) {

        try {

            url = new URL(requestURL);

            connection = (HttpURLConnection) url.openConnection();

            connection.setReadTimeout(150000);
            connection.setConnectTimeout(150000);

            connection.setAllowUserInteraction(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setFixedLengthStreamingMode(register.toString().getBytes().length);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            OutputStreamWriter outputStream = new OutputStreamWriter(connection.getOutputStream());

            outputStream.write(register.toString());

            outputStream.flush();

            Log.e("URL", connection.getURL().toString());
            Log.e("JSONObject", register.toString());
        } catch (Exception e) {
            Log.e("MAIN Exception", e.toString());
        }
        try {

            int statuscode = connection.getResponseCode();

            if (statuscode == HttpURLConnection.HTTP_OK) {
                is = connection.getInputStream();
            } else {

            }
        } catch (IOException e) {
            Log.e("IOException", e.toString());
        }

        try {

            rd = new BufferedReader(new InputStreamReader(is));

            response = new StringBuffer();

            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }
            Log.e("Response", response.toString() + " ");

            rd.close();
        } catch (IOException e) {
            Log.e("BUFFER_READER", e.toString());
        } catch (NullPointerException e) {
            Log.e("NullPointerException", e.toString());
        } finally {
            connection.disconnect();
        }

        try {


            return new JSONObject(response.toString());
        } catch (JSONException e) {
            Log.e("JSONException", e.toString());

        }
        return null;
    }