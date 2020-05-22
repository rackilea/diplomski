package biz.slwdesign.tvlocallysouthdevon;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class Watch extends Activity implements OnClickListener {

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
    setContentView(R.layout.watch);


    //ImageButton1
    ImageButton video1 = (ImageButton) findViewById(R.id.ImageButton1);
    video1.setOnClickListener(this);

    //ImageButton2
    ImageButton video2 = (ImageButton) findViewById(R.id.ImageButton2);
    video2.setOnClickListener(this);

    //ImageButton3
    ImageButton video3 = (ImageButton) findViewById(R.id.ImageButton3);
    video3.setOnClickListener(this);

    //ImageButton4
    ImageButton video4 = (ImageButton) findViewById(R.id.ImageButton4);
    video4.setOnClickListener(this);

    //ImageButton5
    ImageButton video5 = (ImageButton) findViewById(R.id.ImageButton5);
    video5.setOnClickListener(this);

    //ImageButton6
    ImageButton video6 = (ImageButton) findViewById(R.id.ImageButton6);
    video6.setOnClickListener(this);

    //ImageButton7
    ImageButton video7 = (ImageButton) findViewById(R.id.ImageButton7);
    video7.setOnClickListener(this);

    //ImageButton7
    ImageButton video8 = (ImageButton) findViewById(R.id.ImageButton8);
    video8.setOnClickListener(this);

}

public void onClick(View v) {

    setContentView(R.layout.watch);
    VideoView videoview1 = (VideoView) findViewById(R.id.videoView1);
    videoview1.setMediaController(new MediaController(this));
    if(v.getId() == R.id.ImageButton1){
    videoview1.setVideoPath("http://slwdesign.biz/android/austins.mp4");
    }
    if (v.getId() == R.id.ImageButton2){ 
    videoview1.setVideoPath("http://slwdesign.biz/android/brownsWigs.mp4");
    }
    if (v.getId() == R.id.ImageButton3){
    videoview1.setVideoPath("http://slwdesign.biz/android/frames&Boxes.mp4");
    }
    if (v.getId() == R.id.ImageButton4){
    videoview1.setVideoPath("http://slwdesign.biz/android/hatMckool.mp4");
    }
    if(v.getId() == R.id.ImageButton5){
    videoview1.setVideoPath("http://slwdesign.biz/android/gardenTime.mp4");
    }
    if (v.getId() == R.id.ImageButton6){
    videoview1.setVideoPath("http://slwdesign.biz/android/paulBarclay.mp4");
    }
    if (v.getId() == R.id.ImageButton7){
    videoview1.setVideoPath("http://slwdesign.biz/android/fishShed.mp4");
    }
    if(v.getId() == R.id.ImageButton8){
    videoview1.setVideoPath("http://slwdesign.biz/android/offBoutique.mp4");
    }
    videoview1.start();
    videoview1.requestFocus();
}