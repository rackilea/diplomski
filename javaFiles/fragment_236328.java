public class DetailedActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_activity);
        if (savedInstanceState == null) {
            DetailedFragment fragment = DetailedFragment.newInstance(false);
            getSupportFragmentManager().beginTransaction().add(R.id.root_layout_details, fragment, "Some_tag").commit();
        }
    }
}