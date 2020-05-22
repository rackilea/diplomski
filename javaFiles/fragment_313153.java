package com.jamfactory.articles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Main extends Activity {
    private ListView listView1;
    String JSON;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);                   
        String url = “”//the url from where you want to fetch the
JSON
        new PerformBackgroundTask.execute(url);
        // Get JSON

        // Get JSON      


        List article_data[] = new List[]
        {
            new List(R.drawable.cloudy, "Article One", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
            new List(R.drawable.showers, "Article Two", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
            new List(R.drawable.snow, "Article Three", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
            new List(R.drawable.storm, "Article Four", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
            new List(R.drawable.sunny, "Article Five", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
        };





        ListAdapter adapter = new ListAdapter(this,
                R.layout.listview_item_row, article_data);


        listView1 = (ListView)findViewById(R.id.listView1);

        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView1.addHeaderView(header);

        listView1.setAdapter(adapter);
    }}



class PerformBackgroundTask extends AsyncTask<Void, Void, Void> {
String url;
        public PerformBackgroundTask(String url1){
this.url = url1;
}

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub

           JSON = performHtpGet(url)

    //HERE JSON IS THE VALUE WHICH IS FETCHED
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

    }


 private String performHtpGet(String queryUrl ){
            try{
                DefaultHttpClient httpClient = new DefaultHttpClient();
                Log.d("Inside performHtpGet():", "1");
                HttpGet get = new HttpGet(BASE_URL+queryUrl);
                Log.d("Inside performHtpGet():", "2");
                HttpResponse response = httpClient.execute(get);
                Log.d("Inside performHtpGet():", "4");
                String result = EntityUtils.toString(response.getEntity());
                Log.d("Inside performHtpGet():", "5");          
                return result;
            }catch(Exception e){
                return null;
            }
        }