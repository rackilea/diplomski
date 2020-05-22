public class NetworkRequest extends AsyncTask<Void, Void, JSONObject> {

public interface CallbackInterface {

    public void onRequestSuccess(JSONObject jsonObject);

}

String rootUrl="your url";
private CallbackInterface callback;


public NetworkRequest(CallbackInterface callbackInterface,
        List<BasicNameValuePair> params,
        ) {
    this.callback = callbackInterface;
    this.rootUrl =rootUrl + "/?" + URLEncodedUtils.format(params, "utf-8");
}

@Override
protected void onPreExecute() {
    super.onPreExecute();
}

@Override
protected JSONObject doInBackground(Void... params) {

        return networkRequet();
}

private JSONObject networkRequet() {
    String result = null;
    try {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(rootUrl);
        Log.i("url", rootUrl);
        HttpResponse httpResponse = null;
        if (httpGet != null) {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
            Log.i("Result", result);
        }
        return new JSONObject(result);
    } catch (JSONException e) {
        error = ErrorType.JSONPARSER_ERROR;
        e.printStackTrace();
        return null;
    } catch (ClientProtocolException e) {
        error = ErrorType.UNKNOWN_ERROR;
        e.printStackTrace();
        return null;
    } catch (IOException e) {
        error = ErrorType.IO_ERROR;
        e.printStackTrace();
        return null;
    }
}

@Override
protected void onPostExecute(JSONObject result) {
    super.onPostExecute(result);
        callback.onRequestSuccess(result);
}