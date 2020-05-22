public class MainActivity extends Activity implements View.OnClickListener {

private Button btnOne;
private Button btnTwo;
private Button btnThree;

/* Called when the activity is first created.*/
@Override
public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    initialize();
    if(findViewById(R.id.fl) != null)
    {
        if(savedInstanceState != null)
        {
            FragmentTransaction trans = getFragmentManager().beginTransaction();

            //This is where we add our first fragment
            trans.add(R.id.fl, new FragmentOne());
            trans.commit();
        }
    }
}

private void initialize()
{
    btnOne = (Button) findViewById(R.id.button1);
    btnTwo = (Button) findViewById(R.id.button2);
    btnThree = (Button) findViewById(R.id.button3);
    btnOne.setOnClickListener(this);
    btnTwo.setOnClickListener(this);
    btnThree.setOnClickListener(this);
}

public void onClick(View view)
{
    //Here is where we'll actually transfer the fragments

    FragmentTransaction trans = getFragmentManager().beginTransaction();
    switch(v.getId()){
        case R.id.button1:
            trans.replace(R.id.fl, new FragmentOne());
            trans.addToBackStack(null);
            trans.commit();
            break;
        case R.id.button2:
            trans.replace(R.id.fl, new FragmentTwo());
            trans.addToBackStack(null);
            trans.commit();
            break;
        case R.id.button3:
            trans.replace(R.id.fl, new FragmentThree());
            trans.addToBackStack(null);
            trans.commit();
            break;
    }
}