public class Character_activity extends AppCompatActivity {

  private EditText playerEditText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_character_redo);
    playerEditText = (EditText) findViewById(R.id.player);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    playerEditText.setText(savedInstanceState.getString("SavedPlayer", "");
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    outState.putString("SavedPlayer", playerEditText.getText().toString());

    super.onSaveInstanceState(outState);
  }
}