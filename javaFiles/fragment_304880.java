import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    public static final String EXTRA_MESSAGE = "Something Here....";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this will insert the button into the Main Activity layout
        Button goToWelcome = (Button)findViewById(R.id.goToWelcome);

        //this is the onClickListener which will call the method to go to the next activity
        goToWelcome.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View v)
        {
           goToWelcomeActivityMethod();
        }
         });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //you don't need to pass in the View
    public void goToWelcomeActivityMethod()
    {
        Intent intent = new Intent(this, WelcomeActivity.class);
        EditText editText = (EditText) findViewById(R.id.welcomeMessage);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}