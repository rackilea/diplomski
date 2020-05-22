public class MainActivity extends Activity implements HomeFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .add(R.id.mainFrame, new HomeFragment())
                .commit();
    }

    @Override
    public void openHome(View view) {
        System.out.println("Success");
    }

    @Override
    public void onFragmentInteractionHome(Uri uri) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

}