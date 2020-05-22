public class UserSettingPreference extends AppCompatActivity {

Toolbar toolbar;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.toolbar);
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle("Settings");
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                onBackPressed();

        }
    });
    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
            new UserPreferenceFragment()).commit();
}

}