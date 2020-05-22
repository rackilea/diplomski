public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String requiredPermission = "android.permission.WRITE_SECURE_SETTINGS";
    int checkVal = checkCallingOrSelfPermission(requiredPermission);
    if (checkVal == PackageManager.PERMISSION_GRANTED) {
    }
    Toast.makeText(this, "WRITE_SECURE_SETTINGS has been granted to the application. You may now continue!",
            Toast.LENGTH_LONG).show();

    if (checkVal == PackageManager.PERMISSION_DENIED) {
    }
    Toast.makeText(this, "WRITE_SECURE_SETTINGS has not been granted to the application. Please grant access to continue.",
            Toast.LENGTH_LONG).show();
}
}