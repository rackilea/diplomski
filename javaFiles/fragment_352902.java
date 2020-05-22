public class WorkTimerNotification extends ActionBarActivity implements TextToSpeech.OnInitListener {

TextToSpeech tts;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_work_timer_notification);

//line1



}

@Override
public void onInit(int status) {
//line2
tts.setLanguage(Locale.US);

//line3
tts.speak("Text to say aloud", TextToSpeech.QUEUE_ADD, null);

}



@Override
protected void onStart()
{
    super.onStart();

    tts = new TextToSpeech(this,this);
}

@Override
protected void onStop()
{
    super.onStop();
    tts.shutdown();
}