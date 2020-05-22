import android.app.Activity;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends Activity implements View.OnClickListener 
{

    // onClick method is called when one of view is clicked. (you must use setOnClickListener on this View to inform system to call this)
    @Override
    public void onClick(View v)
    {
        // check if clicked view is cd_start
        if(v.getId() == R.id.cd_start)
        {
             // true cd_start is clicked
             displayDateEnd(dateStopKukuk);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); // REQUIRED!!! When you don't add this your app will be crash.
        setContentView(R.layout.activity_main); // sets activity_main as layout (if you use different name of layout replace activity_name with your layout name)
        findViewById(R.id.cd_start).setOnClickListener(this); // finds view with cd_start id and sets click listener. When this view is clicked system calls onClick method.
        // and now your code what do you want to do when activity is creating.
    }

    String dateStopKukuk = "21 Dec 2015";

    private void displayDateEnd(String etime) {
        TextView priceTextView = (TextView) findViewById(R.id.cd_start);
        priceTextView.setText(etime);
    }

    /* You don't need dateEnd method now */
}