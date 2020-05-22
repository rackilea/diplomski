private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        tv = (TextView)findViewById(R.id.resultbox);
        new Task().execute();

    }

    class Task extends AsyncTask<Void, Void, String>{
        @Override
        protected String doInBackground(Void... params) {
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://greentapcore.tumblr.com/");
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                InputStream webs = entity.getContent();
                try{
                    StringBuilder result = new StringBuilder();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(webs,"iso-8859-1"),8);
                    String line;
                    while( (line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    webs.close();
                    return result.toString();

                }catch(Exception e){
                    Log.e("log_tag", "Error converting result "+e.toString());
                }
            }catch(Exception e){
                Log.e("log_tag", "Error in HTTP connection "+e.toString());

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s != null){
                tv.setText(s);
            }
        }
    }