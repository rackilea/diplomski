public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         final TextView helloTextView = (TextView) findViewById(R.id.text_view_id);
         helloTextView.setText(R.string.user_greeting);
     }
 }