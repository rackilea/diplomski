public class MyActivity implements OnItemClickListener{

    ListView  lv;

    @Override
    public void onCreate(Bundle savedInstanceState() {
        ....
        ....
        // lv initialized here
        // adapter of lv set here
        attachListeners();
    }

    private void attachListeners() {
        ....
        ....
        // attach listeners to other views if you like
        lv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // code to handle click
    }
}