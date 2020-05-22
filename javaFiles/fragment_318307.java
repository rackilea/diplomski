import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyActivity extends Activity {

    private OurView v;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        v = new OurView(this);
        setContentView(v);
    }

    @Override
    protected void onPause() {
        super.onPause();
        v.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        v.resume();
    }

    public class OurView extends SurfaceView implements Runnable {

        Thread t = null;
        SurfaceHolder holder;
        boolean isOk = false;

        public OurView(Context context){
            super(context);
            holder = getHolder();
        }

        public void run(){
            if(isOk){

            }
        }

        public void pause(){
            isOk = false;
            while (true){
                try {
                    t.join();
                    t = null;
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void resume(){
            isOk = true;
            t = new Thread(this);
            t.start();
        }
    }
}