public class LoginScreen  extends FragmentActivity implements OnClickListener
{


    FragmentTransaction transaction;

    @Override
     protected void onCreate(Bundle savedInstanceState) 
     {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login_screen);



        MainFragment mainFrag=new MainFragment();
        FragmentManager manager=getSupportFragmentManager();//create an instance of fragment manager
        transaction=manager.beginTransaction();
        transaction.add(R.id.MyFrameLayout,mainFrag, "userlogin");
        transaction.commit();



    }


}