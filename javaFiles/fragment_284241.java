public class MainActivity extends ListActivity{// implements FetchDataListener,OnClickListener{
     private GinfyDbAdapter mDbHelper;
     JSONArray contacts = null;
        private SimpleCursorAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        mDbHelper=new GinfyDbAdapter(MainActivity.this);
        mDbHelper.open();
        Cursor projectsCursor = mDbHelper.fetchAllProjects();
        if(projectsCursor!=null)
        {
        fillData(projectsCursor);
        }
        else
        {
             new GetDataAsyncTask().execute();
        }
    }

    private class GetDataAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog Dialog = new ProgressDialog(MainActivity.this);

        protected void onPreExecute() {
            Dialog.setMessage("Loading.....");
            Dialog.show();
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Dialog.dismiss();

            Cursor projectsCursor = mDbHelper.fetchAllProjects();
            if(projectsCursor!=null)
            {
            mDbHelper=new GinfyDbAdapter(MainActivity.this);
            mDbHelper.open();
            fillData(projectsCursor);
            }
        }
        @Override
        protected Void doInBackground(Void... params) {
            getData();
            return null;
        }
    }
    public void getData()
    {
          try
            {
        HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpGet request = new HttpGet("http://www.ginfy.com/api/v1/posts.json");
        // HttpGet request = new HttpGet("http://gdata.youtube.com/feeds/api/users/mbbangalore/uploads?v=2&alt=jsonc");     

        HttpResponse response = httpclient.execute(request);
        HttpEntity resEntity = response.getEntity();
        String _response=EntityUtils.toString(resEntity); // content will be consume only once
         Log.i("................",_response);
        httpclient.getConnectionManager().shutdown();
        JSONObject jsonObject = new JSONObject(_response);
        JSONArray contacts = jsonObject.getJSONArray("post");//(url);
            for(int i = 0; i < contacts.length(); i++){
                JSONObject c = contacts.getJSONObject(i);
                String id = c.getString("id");
                String title = c.getString("title");
                String  content = c.getString("content");
                String  count = c.getString("content");
                mDbHelper=new GinfyDbAdapter(MainActivity.this);
                mDbHelper.open();
                mDbHelper.saveCategoryRecord(new Category(id,title,content,count));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    @SuppressWarnings("deprecation")
    private void fillData(Cursor projectsCursor) {
        //mDbHelper.open();   

        if(projectsCursor!=null)
        {
        String[] from = new String[]{GinfyDbAdapter.CATEGORY_COLUMN_TITLE, GinfyDbAdapter.CATEGORY_COLUMN_CONTENT, GinfyDbAdapter.CATEGORY_COLUMN_COUNT};
        int[] to = new int[]{R.id.textView1, R.id.textView2, R.id.textView3};
         dataAdapter  = new SimpleCursorAdapter(
          this, R.layout.activity_row, 
          projectsCursor, 
          from, 
          to,
          0);
         setListAdapter(dataAdapter);
        }else
        {
            Log.i("...........","null");
        }
    }
}