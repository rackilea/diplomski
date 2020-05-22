public class SnagData extends AsyncTask<URL, Void, String> {
  String TAG_PARENT = "results";
    String TAG_TITLE = "title";
    String TAG_INFO = "info";
    public interface returnListListener
    {
        public void returnList(ArrayList<HashMap<String,String>> list);
    }
    returnListListener mCallback;
public SnagData(Context context)
{
    mCallback = (returnListListener)context;
}

ArrayList<HashMap<String,String>> booklist = new ArrayList<HashMap<String,String>>();
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(URL... urls) {

        String fURL = "";
        for (URL url : urls) {


            fURL = NetworkConnection.getURLResponse(url);
        }

        return fURL;
    }


    protected void onPostExecute(String result) {
        try {


            JSONObject json = new JSONObject(result);

            JSONArray results = json.getJSONArray(TAG_PARENT);

            int j = results.length();


            for (int i = 0; i < j; i++) {


                JSONObject jo = results.getJSONObject(i);


                String title = jo.getString(TAG_TITLE);
                String info = jo.getString(TAG_INFO);


                HashMap<String, String> map = new HashMap<String, String>();

                map.put(TAG_TITLE, title);
                map.put(TAG_INFO, info);


                bookList.add(map);
                if(mCallback!=null)
                {
                    mCallback.returnList(booklist);
                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}