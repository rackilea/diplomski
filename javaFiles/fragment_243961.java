public class MainActivity extends AppCompatActivity {


    TextView txtname,txtcount,txtspam,txtresults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname = (TextView)findViewById(R.id.txtname);
        txtcount = (TextView)findViewById(R.id.txtcount);
        txtspam = (TextView)findViewById(R.id.txtspam);
        txtresults = (TextView)findViewById(R.id.txtresults);


        String response = "{\"results\":[{\"displayName\":\"Jack\",\"count\":\"5\",\"results\":[\"jack\",\"sam\",\"kelly\"],\"spam\":\"14\"}]}";
        String name="",count="",spam="",results="";

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);

            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);
                name = jo.getString("displayName");
                count = jo.getString("count");
                spam = jo.getString("spam");
                JSONArray jsonArray1 = jo.getJSONArray("results");

                for(int j=0;j<jsonArray1.length();j++){
                    results += jsonArray1.get(j)+",";
                }
            }

            txtname.setText(name);
            txtcount.setText(count);
            txtspam.setText(spam);
            txtresults.setText(results);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}