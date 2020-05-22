public class MainActivity extends AppCompatActivity {


    private android.view.View mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void test_btn(View V){

        SecondFragment newGamefragment = new SecondFragment.newInstance("asdas");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment2 , newGamefragment);
        transaction.addToBackStack(null);
        transaction.commit();



    }



}

//SecondFragment



public class SecondFragment extends Fragment {

    private TextView updateText;


    public static SecondFragment newInstance(String str) {
        SecondFragment s= new SecondFragment ();
        Bundle args = new Bundle();
        args.putString("str", str);
        signUpFragment.setArguments(args);
        return s;
    }

    public SecondFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        updateText = (TextView)view.findViewById(R.id.text_update);
        if (getArguments() != null)
            updateTextField( getArguments().getString("str"));
        return view;
    }


    public void updateTextField(String newText){
        updateText.setText(newText);
    }
}