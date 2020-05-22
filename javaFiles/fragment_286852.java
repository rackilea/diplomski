public class YourActivity extends Activity implements OnClickListener {
Button btnForward;
Button btnBackward;

@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnForward=(Button) findViewById (R.id.btnForward);
        btnBackward=(Button) findViewById (R.id.btnBackward);

        //set listeners
        btnForward.setOnClickListener(this);
        btnBackward.setOnClickListener(this);

        // your code here .... 
    }

@Override
public void onClick(View v ) {
     switch(v.getId()) {

        case R.id.btnBackward:
            WebViewClientDemoActivity.web.goBack();
           break;
        case R.id.btnForward:
            WebViewClientDemoActivity.web.goForward();
           break;
    }
}