public class WebService extends AsyncTask<String,String,String> {
private static final String TAG="SyncToServerTAG";




private String urlString;
private JSONObject jsonObject=null;
private int screenId=1;

public WebService(String url) {
    this.urlString=url;
}

public WebService(Context context, String url, JSONObject jsonObject) {
    this.urlString = url;
    this.jsonObject = jsonObject;
}

@Override
protected String doInBackground(String... strings) {
    try {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setChunkedStreamingMode(0);
        urlConnection.setConnectTimeout(5000);
        urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setRequestMethod("POST");
        if(jsonObject!=null) {
            OutputStream os = urlConnection.getOutputStream();
            os.write(jsonObject.toString().getBytes("UTF-8"));
        }

        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (urlConnection.getInputStream())));

        String output="";
        while (true) {
            String line=br.readLine();
                Log.d(TAG,line+" ");
            if(line!=null)
                output+=line;
            else
                break;
        }

        in.close();
        urlConnection.disconnect();
        JSONObject j;
        if(output.equals(""))
            publishProgress("Server give null");
        else {
            j=new JSONObject(output);
            return output;
        }
        return output;
    } catch (MalformedURLException e) {
        e.printStackTrace();
        publishProgress(e.toString());
    } catch (IOException e) {
        e.printStackTrace();
        publishProgress(e.toString());
    } catch (JSONException e) {
        e.printStackTrace();
        publishProgress(e.toString());
    }
    return null;
}

@Override
protected void onProgressUpdate(String... values) {
    super.onProgressUpdate(values);
    fireError(values[0]);
}

@Override
protected void onPostExecute(String s) {
    super.onPostExecute(s);
    if(s!=null) {
        try {
            JSONObject jsonObject=new JSONObject(s);
            fireComplete(0, jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
            fireError("Non acceptable responds from server ["+urlString+"]");
        }
    }
}

public interface OnWebCompleteListener{
    void onComplete(JSONObject result, int dataSource);
    void onError(String error);
}
private OnWebCompleteListener onWebCompleteListener;
private void fireComplete(int sourse,JSONObject cache){
    if(onWebCompleteListener!=null)
        onWebCompleteListener.onComplete(cache,sourse);
}
private void fireError(String message){
    if(onWebCompleteListener!=null)
        onWebCompleteListener.onError(message);
}
public void start(OnWebCompleteListener onWebCompleteListener){
    if(onWebCompleteListener==null)
        throw new RuntimeException("You must provide non-null value as start listener");
    this.onWebCompleteListener=onWebCompleteListener;
    execute((String)null);
}

}