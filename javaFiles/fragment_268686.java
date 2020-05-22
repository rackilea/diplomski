public class MainActivity extends Activity {

   // Somewhere in onCreate

    ClassB b = new ClassB();
    b.setOnPlayListener(new OnPlayListener() {
        @Override
        public void onPlay() {
            // Respond to onPlay in this Activity
        }
    }   
}

public class B {
    public void play() {
        // Do stuff for playing
        mOnPlayListener.onPlay(); // Invoke callback to notify play is happening - this will be the activity
    }

    public void setOnPlayListener(OnPlayListener listener) {
        mOnPlayListener = listener;
    }
}