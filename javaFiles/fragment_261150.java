public class MainActivity extends Activity {
private ListView listView;
private List<FeedsDTO> feedsList = new ArrayList<FeedsDTO>();
private FeedsDTO dto  = null;
private BackgroundThread backgroundThread;
private CustomAdapter customAdapter = null;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    listView = (ListView) findViewById(R.id.listview);
    backgroundThread = new BackgroundThread();
    backgroundThread.execute();
}
private void setListViewAdapter(){
    customAdapter = new CustomAdapter(this, R.layout.listitem, feedsList);
    listView.setAdapter(customAdapter);
}
private class BackgroundThread extends AsyncTask<Void, Void, String> {
    private ProgressDialog progressBar = null;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar = new ProgressDialog(MainActivity.this);
        progressBar.setCancelable(false);
        progressBar.show();

    }
    @Override
    protected String doInBackground(Void... params) {
        BufferedReader reader = null;
        String webc = "";
        try{
            URL url = new URL("http://gdata.youtube.com/feeds/api/users/thecovery/uploads?v=2&alt=json");
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while((read = reader.read(chars)) != -1){
                buffer.append(chars,0,read);
            }
            webc = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    return webc;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(webc);
        return webc;
    }
    @Override
    protected void onPostExecute(String result) {
        JSONObject obj;
        try {
            obj = new JSONObject(result);
            JSONArray feed = obj.getJSONObject("feed").getJSONArray("entry");
            Log.i("=======", "========="+feed.length());
            for(int i = 0; i < feed.length(); i++){
                dto = new FeedsDTO();
                dto.setName(feed.getJSONObject(i).getJSONObject("title").getString("$t"));
                dto.setLink(feed.getJSONObject(i).getJSONArray("link").getJSONObject(0).getString("href"));
                feedsList.add(dto);
                dto = null;
            }
            Log.i("=======LIst Size", "========="+feedsList.size());
            progressBar.dismiss();
            setListViewAdapter();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.onPostExecute(result);
    }
}