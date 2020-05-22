public class SplashActivity extends AppCompatActivity {

private Context context;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    context = this;

    checkConnection();

    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
    finish();
}