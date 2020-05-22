public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.txtQuit);
}

public void quit(View view) {
    Intent intent = new Intent(this, SecondActivity.class);
    startActivity(intent);
    finish();
}