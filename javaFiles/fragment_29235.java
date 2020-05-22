import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.Point;

public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.main)

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int width = size.x;
        int height = size.y;

        //Set two textViews to display the width and height
        //ex: txtWidth.setText("X: " + width);
    }
}