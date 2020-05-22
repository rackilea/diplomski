import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MyThread((TextView) findViewById(R.id.textView)).start();

    }


    class MyThread extends Thread implements Runnable {

        TextView textView;

        MyThread(TextView textView) {
            this.textView = textView;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnMainUiThread(new Callable() {
                    @Override
                    public Object call() throws Exception {
                        textView.setText("" + System.currentTimeMillis());
                        return null;
                    }
                });

            }
        }

        void runOnMainUiThread(final Callable callable) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    try {
                        callable.call();
                    } catch (Exception e) {
                        Log.e("MyThread", "runOnMainUiThread: ", e);
                    }
                }
            });
        }
    }
}