public class UnicalNotificationsActivity extends ListActivity {
    String notificationlinks[] = new String[100];
    String notificationnames[] = new String[100];
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create a list view 
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(UnicalNotificationsActivity.this,R.layout.exams,notificationnames);
        setListAdapter(adapter);
        ListView lv = getListView();

        //Set item click listener
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                //When an item is clicked, send the corresponding link to getResults class
                Intent i = new Intent(getApplicationContext(), getResults.class);       
                i.putExtra("examlink", notificationlinks[(int)arg3]);
                startActivity(i);

            }

        });

        new DownloadNotificationTask().execute();
    }


    /////////////////////////
    private class DownloadNotificationTask extends AsyncTask<String, Void, String> {
        @Override
            protected void onPreExecute(){
            Toast.makeText(UnicalNotificationsActivity.this ,"Loading", Toast.LENGTH_LONG);
        }
        @Override
            protected void onPostExecute(String result) {


        }
        @Override
            protected String doInBackground(String... arg0) {
            URL uni = null;
            try {
                uni = new URL("http://universityofcalicut.info/index.php?option=com_content&task=view&id=744&Itemid=324");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            String url=uni.toString();
            Document doc = null;

            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Elements links = doc.select("a[href]");
            int index=-1;
            int i=0;

            //Iterate every link and select only those with the string containing 202.88.252.6
            for (Element link : links) {
                index=-1;
                index=link.attr("abs:href").indexOf(".pdf");

                if(index!=-1 && link.attr("abs:href")!=null && link.text()!=null && link.text()!=" " && i<100)
                {
                    //Store the link and corresponding names
                    notificationlinks[i]=link.attr("abs:href");
                    notificationnames[i]=link.text();

                    Log.d("PDF FOUND", notificationlinks[i]);
                }
            }
            return null;
        }
    }
    ///////////////
}