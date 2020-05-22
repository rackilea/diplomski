public class AnyActivity extends AppCompatActivity {
    //instance created
    AnyFragment anyFrag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       //initializing the intsance        
       anyFrag=new AnyFragment()
       
       //using the privious ariable again insted of making new instance
       loadFragment(anyFrag,R.id.CONTAINERID);
       
    }


    //Your function which loads the fragment
    public void loadFragment(Fragment targetFragment, int containerId) {
        supportFragmentManager.beginTransaction().replace(containerId, targetFragment, targetFragment.getClass().getName()).commit();
    }


}