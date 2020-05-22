try {
    URL url = new URL("http://data.cubscout.local/enter_game_design");
    boolean redirect = false;

    do {
        redirect = false;
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        Log.d("Test","url: "+connection.getURL());

        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);

        connection.setInstanceFollowRedirects(false);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty("Content-Type","application/json;charset=utf-8");
        connection.setRequestProperty("Accept","application/json");

        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write("{\"test_value\":\"test\"}");
        writer.flush();
        writer.close();

        Log.d("Test","json sent");

        int httpResult = connection.getResponseCode();
        Log.d("Test","http response code: "+httpResult);
        if(httpResult == HttpURLConnection.HTTP_OK){
            Log.d("Test", IOUtils.toString(connection.getInputStream()));
            Log.d("Test", "result read");
        }
        else if(   httpResult == HttpURLConnection.HTTP_MOVED_PERM
                || httpResult == HttpURLConnection.HTTP_MOVED_TEMP
                || httpResult == HttpURLConnection.HTTP_SEE_OTHER){
            redirect = true;
            url = new URL(connection.getHeaderField("Location"));
        }
    } while (redirect);
} catch (MalformedURLException e) {
    Log.e("Test","exception while sending data to server",e);
} catch (ProtocolException e) {
    Log.e("Test","exception while sending data to server",e);
} catch (IOException e) {
    Log.e("Test","exception while sending data to server",e);
}