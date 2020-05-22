import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

// METHOD 1     

         /****** Create Thread that will sleep for 10 seconds *************/        
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 10 seconds
                    sleep(10*1000);

                    // After 10 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),AnotherScreen .class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();

//METHOD 2  

        /*
        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override
            public void run() {
                Intent i = new Intent(MainScreen.this, AnotherScreen.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 10*1000); // wait for 10 seconds
        */
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }}