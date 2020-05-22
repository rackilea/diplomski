public class MainActivity extends AppCompatActivity {

    private PopupWindow mPopup = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void popup(View v) {
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.activity_alert_dialog,null);

        // Use global variable instead of local.
        //final PopupWindow popup= new PopupWindow(layout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mPopup= new PopupWindow(layout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        View vi=(View) findViewByID(R.id.Layout);
        mPopup.showAtLocation(vi, 0, 20, -50);
    }

    public void dismiss(View v) {
        if (mPopup != null && mPopup.isShowing()) {
            mPopup.dismiss();
        }    
    } 
}