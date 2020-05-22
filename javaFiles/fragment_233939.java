public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentOne(), "one").commit();
        }        
    }

    public void showFragmentTwo(String name) {
        FragmentTwo fragmentTwo = new FragmentTwo();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        fragmentTwo.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                  .replace(R.id.fragment, fragmentTwo, "two")
                  .addToBackStack(null)
                  .commit();
    }
}