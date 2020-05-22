public  class Intro extends Activity implements OnClickListener
{
/** Called when the activity is first created. */

@Override
public void onCreate(Bundle savedInstanceState) 
{
    Log.d("Error"," Intro Started ");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.intro);

}

public void onClick(View v) {
    //handle button event 
} 
}