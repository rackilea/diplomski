private class GetContent extends AsyncTask<Void, Void, String>{

HttpURLConnection urlConnection = null;
BufferedReader reader = null;
String resultJson = "";

@Override
protected String doInBackground(Void... params) {

    try{
        URL url = new URL("http://www.json-generator.com/api/json/get/bSFiRdwiSq?indent=2");

        urlConnection = (HttpURLConnection)url.openConnection();
        urlConnection.setRequestMethod("GET");

        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        StringBuilder builder = new StringBuilder();
        int line;
        while ((line=reader.read()) > 0){
            builder.append((char)line);
        }
        reader.close();
        inputStream.close();
        String resultJson = builder.toString();

        Log.d("Result:", resultJson);

    } catch (MalformedURLException e) {
        e.printStackTrace();

    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}
}