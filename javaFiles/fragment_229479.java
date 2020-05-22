public class MainActivity extends Activity {

    FragmentA f1;
    FragmentB f2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        f1 = (FragmentA) manager.findFragmentById(R.id.fragment1);
        Log.d("this", "setCommunicator");

    }

   /* @Override
    public void respone(int index) {
        // TODO Auto-generated method stub

        f2 = (FragmentB) manager.findFragmentById(R.id.fragment2);
        Log.d("this", "f2 referenced from Main");
        if (f2 != null && f2.isVisible())// landscape
        {
            f2.changeText(index);
        } else // portrait
        {
            Intent i = new Intent(this, AnotherActivity.class);
            i.putExtra("index", index);
            startActivity(i);
        }
    }*/

}