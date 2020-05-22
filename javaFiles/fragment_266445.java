import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class MainActivity extends Activity implements Callback {

Handler handler;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    handler = new Handler(this);
    Proxy proxy = new Proxy(handler);
    proxy.foo();
}

private class Proxy {

    Handler handler;

    public Proxy(Handler handler) {
        this.handler = handler;
    }

    private void foo() {
        new myAsync().execute();
    }

    private class myAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Message msg = handler.obtainMessage();
            msg.obj = result;
            handler.sendMessage(msg);
        }

    }
}

@Override
public boolean handleMessage(Message msg) {
    // Handle Message here!
    return false;
}
}