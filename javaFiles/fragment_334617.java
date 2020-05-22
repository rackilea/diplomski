public class Downloader extends AsyncTask<String, Void, String> {

@Override
protected String doInBackground(String... urls) {
    String result ="";
    try{
        URL url = new URL(urls[0]);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = "";
        while((line=reader.readLine())!= null){
            result= result + line;
        }
        connection.disconnect();

    } catch (Exception e) {
        Log.e("Error fetching", e.toString());
    }

    return result;
}
}