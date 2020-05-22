public class StackStackActivity extends Activity 
{

    String[] myArray = getResources().getStringArray(R.array.glenns); // This returns null

    public StackStackActivity()
    {

        myArray = getResources().getStringArray(R.array.glenns); // This returns null also
    }

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myArray = getResources().getStringArray(R.array.glenns); // Returns an array from resources
    }
}