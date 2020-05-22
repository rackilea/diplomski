public class MainActivity extends AppCompatActivity {
public static MyCallBack mCallback;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

mCallback = new MyCallBack() {
    @Override
    public void refreshMainActivity() {
           MainActivity.this.recreate();

              "OR"

              finish();
              startActivity(getIntent());
         }
    };
}