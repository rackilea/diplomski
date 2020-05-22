public class Demo7 extends AppCompatActivity implements TextToSpeechIniListener {

private Button b;
private TextToSpeechInitializer i;
private TextToSpeech talk;
private boolean flag = false;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.demo7);
    i = new TextToSpeechInitializer(this, Locale.UK, this);
    b = (Button) findViewById(R.id.b);


    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(flag) {
                talk.addEarcon("Attention", getPackageName(), R.raw.androidcalm);
                talk.playEarcon("Attention", QUEUE_ADD, null);
                //talk.setLanguage(Locale.UK);
                talk.speak("Hello, Testing", QUEUE_ADD, null);
            }
        }
    });
}

@Override
protected void onDestroy() {
    super.onDestroy();
    if(talk != null){
        talk.stop();
        talk.shutdown();
    }
}

@Override
public void onSucces(TextToSpeech tts) {
    this.talk = tts;
    flag = true;
}

@Override
public void onFailure(TextToSpeech tts) {
    flag = false;
    finish();
}
}