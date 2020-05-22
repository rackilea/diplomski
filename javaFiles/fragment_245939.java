public class PostActivity extends AsyncTask<Object, Void, JSONArray> {

MyListener mListener;

public PostActivity(MyListener listenr) {
    mListener = listenr;
}

@Override
protected JSONArray doInBackground(Object... arg0)
{
  // your code
  jsonResponse = new JSONArray(result);
  return jsonResponse;
}

@Override
protected void onPostExecute(JSONArray result){

 mListener.your_callback(result); // send the result back to the fragment,
} 

}