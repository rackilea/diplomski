import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class ViewCarsEntered extends Activity implements OnTouchListener
{

private TextView displayCars;
private TextView displaySuggestionMessage;
private HttpPost post;
private HttpResponse httpResponse;
private HttpClient client;
private ProgressDialog dialog = null;

@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_cars_entered);
    displayCars = (TextView)findViewById(R.id.carSpaceDisplay);
    displaySuggestionMessage = (TextView)findViewById(R.id.carSpaceSuggestionsBox);
    displayCars.setOnTouchListener(this);
}

/**
 * Connect to the database 
 * @return String
 */
private class ConnectToDatabase extends AsyncTask<String,Void,String>
{
    @Override
    protected String doInBackground(String... arg0) 
    {
        String serverResponse = " ";

        try
        {
            client = new DefaultHttpClient();
            post = new HttpPost("http://server_ip/folder_for_php_script/connect_to_database.php");
            httpResponse = client.execute(post);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            serverResponse = client.execute(post, responseHandler);

        }catch(Exception e){
            serverResponse = "Could not connect to Database";
            Log.e("Error_Tag", e.toString());
        }
        return serverResponse;
    }

    @Override
    protected void onPostExecute(String result)
    {
        displayCars.setText(result);

        int responseCheck = Integer.parseInt(result);

        if( responseCheck <= 7 )
        {
            displayCars.setTextColor(Color.BLACK);
            displaySuggestionMessage.setText("It is ok to park in the main car park");
        }

        else if( responseCheck <= 11)
        {
            displayCars.setTextColor(Color.YELLOW);
            displaySuggestionMessage.setText("You may want to try the B block");
        }

        else if( responseCheck >= 12)
        {
            displayCars.setTextColor(Color.RED);
            displaySuggestionMessage.setText("Consider Alternate Parking");
        }
    }   
}

/**
 * Constructor for the AsynchronousTask inner Class
 */
public void ConnectToDatabase()
{
    ConnectToDatabase connect = new ConnectToDatabase();
    connect.execute();
}

@Override
public boolean onTouch(View v, MotionEvent event) 
{
    ConnectToDatabase();
    return true;
}

@Override
public boolean onCreateOptionsMenu(Menu menu) 
{
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.view_cars_entered, menu);
    return true;
}
}