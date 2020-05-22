//package name
//imports
public class RecordPlayActivity extends AppCompatActivity implements View.OnClickListener {
// declare buttons here
private MediaRecorder myAudioRecorder;
private String recordOutputFile;
private MediaPlayer mediaPlayer;

@Override
public void onCreate(Bundle savedInstanceState){
    super.onCreate(null);
    setContentView(R.layout.layout_name);
    //find buttons view by Id here
    record.setOnClickListener(this);
    stop.setOnClickListener(this);
    play.setOnClickListener(this);
    recordOutputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";
    myAudioRecorder = new MediaRecorder();
    myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
    myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
    myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
    myAudioRecorder.setOutputFile(recordOutputFile);
    mediaPlayer = new MediaPlayer();
    mediaPlayer.setDataSource(recordOutputFile);
    //Initial condition
    //stop.setEnabled(false);   //not required as stop can be made always enabled
    play.setEnabled(false);
}

@Override
public void onClick(View view){
    switch(view.getId()){
        case R.id.idForRecord:
            myAudioRecorder.prepare();
            myAudioRecorder.start();
            //Recording started
            record.setEnabled(false);
            // don't make play enabled cause you dont want to play
            // and record at same time without stopping record.
            play.setEnabled(false); //required because play can get enabled from stop but it should not remain when recording
            break;
        case R.id.idForStop:
            //if clicked after record
            myAudioRecorder.stop();
            myAudioRecorder.reset();
            //if clicked after play
            if(mediaPlayer.isLooping()) {
                mediaPlayer.stop();
            }
            //recording stopped and saved;
            record.setEnabled(true);
            play.setEnabled(true);
            break;
        case R.id.idForPlay:
            mediaPlayer.prepare();
            mediaPlayer.start();
            //playing
            record.setEnabled(false); // you dont wanna play and record at same time
            break;
        default:
    }
}