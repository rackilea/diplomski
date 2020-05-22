public class MainActivity extends Activity {

private GridView mList;
private ArrayList<FriendBean> arr = new ArrayList<FriendBean>();
private FriendAdapter friendAdapter;
String friend_name, friend_phone, url, des;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mList = (GridView) findViewById(R.id.gridView1);
    StringBuffer sb = new StringBuffer();
    BufferedReader br = null;

    try {
        br = new BufferedReader(new InputStreamReader(getAssets().open(
                "gridarray.json")));
        String temp;
        while ((temp = br.readLine()) != null)
            sb.append(temp);
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } finally {
        try {
            br.close(); // stop reading
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    String myjsonstring = sb.toString();

    try {
        JSONObject obj = new JSONObject(myjsonstring);
        JSONArray jsonarray = obj.getJSONArray("json");
        Log.e("Length", "" + jsonarray.length());
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonObj = jsonarray.getJSONObject(i);
            friend_name = jsonObj.getString("friend_name");
            friend_phone = jsonObj.getString("friend_phone");
            url = jsonObj.getString("image_url");
            des = jsonObj.getString("des");
            FriendBean bean = new FriendBean(url, friend_name, friend_phone,
                    des);
            arr.add(bean);
            Log.e("u", url);
            Log.e("friend_name", friend_name);
            Log.e("friend_phone", friend_phone);
        }

        friendAdapter = new FriendAdapter(MainActivity.this, R.layout.row, arr);
        mList.setAdapter(friendAdapter);
        mList.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Clicked on " + arg2,
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), NewPage.class);
                i.putExtra("friend_name", arr.get(arg2).getName());
                i.putExtra("friend_phone", arr.get(arg2).getPh());
                i.putExtra("url", arr.get(arg2).getImage());
                i.putExtra("des", arr.get(arg2).getDes());
                startActivity(i);
            }
        });

    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}