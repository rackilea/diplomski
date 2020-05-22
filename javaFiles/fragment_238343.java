import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView alfredo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alfredo = (ImageView) findViewById(R.id.alfredo);
        //set invisible
        alfredo.setVisibility(View.INVISIBLE);

        final OnClickListener changeImage = new OnClickListener() {
            public void onClick(View v) {
                //show image on the center of screen
                //set image
                alfredo.setImageResource(R.drawable.alfredo);
                // set visible
                alfredo.setVisibility(View.VISIBLE);
            }
        }

        alfredo.setOnClickListener(changeImage);

        Button one = (Button) this.findViewById(R.id.button1);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.chtmpier);
        one.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                mp.start();
                changeImage.onClick(v);
            }
        });
    }
}