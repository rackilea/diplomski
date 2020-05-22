public class DisplayMessage extends Activity {

 private TextView name;
 private TextView number;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.display_activity);

    name = findViewById(R.id.NameText);
    number = findViewById(R.id.NumberText);

    Intent getText = getIntent();
    String TheName =getText.getStringExtra("Name");
    String TheNumber =  getText.getStringExtra("Number");

    name.setText(TheName);
    number.setText(TheNumber);

}