public class HomeActivity extends AppCompatActivity {
 @Override protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_home);
  BottomNavigationView bottomNavigationView = 
  (BottomNavigationView)findViewById(R.id.bottom_navigation);
  BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
  } //END_ON_CREATE_METHOD
 }/END_HOMEACTIVITY_CLASS