public class Main extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    kalkulatorFragment kalkulator_fragment = new kalkulatorFragment();
    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();

    ft.replace(android.R.id.content, kalkulator_fragment);
    ft.commit();

    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
}