public class MainActivity extends ActionBarActivity {
CharSequence totalString = "Total:"; // getString(R.string.total);
Context context;
int duration = Toast.LENGTH_SHORT;
CharSequence toastText;
// String total = getString(R.string.total);

int num = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    context = getApplicationContext();
}
...