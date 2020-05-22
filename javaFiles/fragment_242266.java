import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity 
{

@Override
protected void onCreate(Bundle savedInstanceState) 
{

    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    LinearLayout layout = (LinearLayout)findViewById(R.id.layoutID ); // //layoutID is id of the linearLayout that defined in your main.xml file

    ImageView img = new ImageView(this);
    ViewGroup.LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    img.setLayoutParams(lp);
    img.setBackgroundResource(R.drawable.c1);
    layout.addView(img);

}
@Override
public boolean onCreateOptionsMenu(Menu menu) 
{
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}
}