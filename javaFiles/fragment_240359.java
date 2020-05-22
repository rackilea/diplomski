public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SharedPreferences Saved_Settings = getSharedPreferences("Saved_Settings", MODE_PRIVATE);
    chk_box_PU.setChecked(Saved_Settings.getBoolean("PU", false));
}

public void save_settings(View v) {
    CheckBox chk_box_PU = (CheckBox) findViewById(R.id.chk_box_PU);

    SharedPreferences Saved_Settings = getSharedPreferences("Saved_Settings", MODE_PRIVATE);
    SharedPreferences.Editor prefsEditor = Saved_Settings.edit();

    prefsEditor.putBoolean("PU", chk_box_PU.isChecked());

    prefsEditor.apply();
}}