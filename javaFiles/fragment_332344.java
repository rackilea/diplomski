import com.example.hakslogin.GetChildList;

public class ChildActivity extends ActionBarActivity implements GetChildList {

    Button btn_home;
    Button btn_add;
    private HandleJSON obj;
    public String urlString = "http://192.168.x.xx:xxxx/getdb";

    List<String> child = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);


        obj = new HandleJSON(urlString);
        obj.fetchJSONChild(null);
        lv_child = (ListView)findViewById(R.id.lv_child); 
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, child);
        lv_child.setAdapter(adapter);
    }
    Handler mHandler = new Handler() {
      public void handleMessage(android.os.Message msg) {
        lv_child = (ListView)findViewById(R.id.lv_child); 
         String arr[]=child.toArray(new String[list.size()]);
         String[] Temp= new String[2];
         Temp[0] = arr[2].toString();
         array.add(Temp[0].split(":")[1]);
         String s = Temp[0].toString();
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array);
         lv_child.setAdapter(adapter);
      };
   };



    @Override
    public void onGetChildList(List<String> list) {
       //this method will be called after thread in fetchJSONChild ended
       child = list;
       mHandler.sendEmptyMessage(0);

    }
}