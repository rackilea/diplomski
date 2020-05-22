package testinc.com.randombutton;

import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    // Encapsulating the data just to be safe...
    private int collected = 0;
    private int screenWidth = 300;
    private int screenHeight = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        TextView collectedView = (TextView) findViewById(R.id.collectedTV);
        collectedView.setText("Collected: " + collected);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toRandomPosition(View view) {
        // Based on our collection candy collection:
        collected += 1;
        TextView collectedView = (TextView) findViewById(R.id.collectedTV);
        collectedView.setText("Collected: " + collected);

        // Based on position of our candy:
        Random random = new Random();
        // Understand nextInt(N) will go from 0 -> N-1, also are you trying to control where it can go?
        float candyX = (float) random.nextInt(screenWidth - 50);
        float candyY = (float) random.nextInt(screenHeight - 50);
// I didn't write it, but you need to check these float values if they   exceed the screen width and the screen length. */
        // Sout to check coordinates
        System.out.println(candyX + " : " + candyY);

        // To change margins:
        ImageButton imgButton = (ImageButton) findViewById(R.id.changePlace);
        imgButton.setX(candyX);
        imgButton.setY(candyY);
    }
}