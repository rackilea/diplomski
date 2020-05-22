public class MyActivity extends Activity {
 ...
FloatingActionButton fab;

  @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    fab = findViewById(R.id.fab_capture);
}



 protected void onActivityResult(int requestCode, int resultCode,
         Intent data) {
  ...
    fab.hide();
   ...
 }
}