String API_KEY = "YOUR_API_KEY_STRING";
String input = "1600+Amphitheatre+Parkway,+Mountain+View,+CA";

private static boolean getAddressResult(String input, StringBuilder jsonResults) {
    try {

        URL requestUrl = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + input " + &key=" + API_KEY;
            );
        HttpURLConnection connection = (HttpURLConnection)requestUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();


        responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {

            BufferedReader reader = null;

            InputStream inputStream = connection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return false;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                long elapsedTime = System.currentTimeMillis();
                if(elapsedTime-currentTime>=5000) {
                   return false;
                }
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return false;
            }

            Log.d("Test", buffer.toString());
            return buffer.toString();
        }
        else {
            Log.i(TAG, "Unsuccessful HTTP Response Code: " + responseCode);
            return false
        }
    } catch (MalformedURLException e) {
        Log.e(LOG_TAG, "Error processing Places API URL", e);
        return false;
    } catch (IOException e) {
        Log.e(LOG_TAG, "Error connecting to Places API", e);
        return false;
    } catch (Expcetion e) {
        return false;
    }
    return false;
}