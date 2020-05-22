import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class TcpClient {

private static final String TAG = TcpClient.class.getSimpleName();

private Socket socket;
private PrintWriter out;
private boolean connected;

public TcpClient()
{
    socket = null;
    out = null;
    connected = false;
}


public void connect(Context context, String host, int port)
{
    new ConnectTask(context).execute(host, String.valueOf(port));
}

private class ConnectTask extends AsyncTask<String, Void, Void> {

    private Context context;

    public ConnectTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        showToast(context, "Connecting..");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void result) {
        if (connected) {
            showToast(context, "Connection successfull");
        }           
        super.onPostExecute(result);
    }

    private String host;
    private int port;

    @Override
    protected Void doInBackground(String... params) {
        try {
            String host = params[0];
            int port = Integer.parseInt(params[1]);
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            showToast(context, "Don't know about host: " + host + ":" + port);
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            showToast(context, "Couldn't get I/O for the connection to: " + host + ":" + port);
            Log.e(TAG, e.getMessage());
        }
        connected = true;
        return null;
    }


}

public void disconnect(Context context)
{
    if ( connected )
    {
        try {
            out.close();
            socket.close();
            connected = false;
        } catch (IOException e) {
            showToast(context, "Couldn't get I/O for the connection");
            Log.e(TAG, e.getMessage());
        }            
    }
}


/**
 * Send command to a Pure Data audio engine. 
 */
public void send(String command)
{
    if ( connected ) out.println(command +";");   
}

private void showToast(final Context context, final String message) {
    new Handler(context.getMainLooper()).post(new Runnable() {

        @Override
        public void run() {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    });
}
}