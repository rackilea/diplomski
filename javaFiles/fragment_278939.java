package interactive.siddiqui.fortuneteller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GameView extends Activity{

    private Button btn;


    private boolean tf = false;
    private boolean canMove = true;
    private Timer timer;

    private final long SPLASH_DISPLAY_LENGTH = 500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_view, menu);
        return true;
    }

    public void start()
    {
        canMove = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(
                new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        moveButton();
                    }
                },
                SPLASH_DISPLAY_LENGTH,
                SPLASH_DISPLAY_LENGTH
        );
    }

    private void moveButton()
    {
        if(!canMove){ return; }

        runOnUiThread(
                 new Runnable()
                 {
                     @Override
                     public void run()
                     {
                        Button btn = (Button)findViewById(R.id.button9);
                        Random r = new Random();

                        int x = r.nextInt(480);
                        int y = r.nextInt(800);

                        btn.setX(x);
                        btn.setY(y);
                    }
                }
        );
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




    public void bob(View view)
    {
        canMove = false;

        if(timer != null)
        {
            try
            {
                timer.cancel();
                timer.purge();
            }catch(Exception e){ e.printStackTrace(); }

            timer = null;
        }

        Intent intent = new Intent(GameView.this, Finished.class);
        startActivity(intent);
        tf = true;
    }
}