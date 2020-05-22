package pete.android.study;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class Main extends Activity implements OnClickListener {
        // declare controls
        public int count = 0;
        MediaPlayer mediaPlayer = null;  
        ToggleButton toggleRain = null;
        /*
         * (non-Javadoc)
         * @see android.app.Activity#onCreate(android.os.Bundle)
         */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            // load layout
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            // load controls
            toggleRain = (ToggleButton)findViewById(R.id.toggleRain);
            // init player
            mediaPlayer = MediaPlayer.create(this, R.raw.rain);
            // set click event handler
            toggleRain.setOnClickListener(this);
            // init state for playing
            count = 0;
        }

        /*
         * (non-Javadoc)
         * @see android.view.View.OnClickListener#onClick(android.view.View)
         */
        @Override    
        public void onClick(View toggleRain) {
            if(count == 0){
                mediaPlayer.start();
                count = 1;
            } else {
                mediaPlayer.pause();                
                count = 0;
            }
        }

        /*
         * (non-Javadoc)
         * @see android.app.Activity#onDestroy()
         */
        @Override
        protected void onDestroy() {
            if(mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }

}