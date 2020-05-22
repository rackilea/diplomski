public class MainActivity extends AppCompatActivity implements View.OnClickListener{

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button new_user_button = (Button) findViewById(R.id.new_user_button);
    new_user_button.setOnClickListener(this);
}

@Override
public void onClick(View v) {
    Log.i("clicks", "You Clicked New User");
    Intent i=new Intent(MainActivity.this, LoginActivity.class);
    startActivity(i);
}

}