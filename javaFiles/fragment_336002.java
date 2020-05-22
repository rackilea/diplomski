public class MyActivity {

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
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // code to handle click
            }
        });
    }        
}