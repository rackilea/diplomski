public class XButtonSound extends Activity implements OnTouchListener {

private int sound;
private SoundPool sounds;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Button donePlacing = new Button(this.getApplicationContext());
    donePlacing.setId(1);
    donePlacing.setText("Play");
    donePlacing.setOnTouchListener(this);

    this.addContentView(donePlacing, new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));


    sounds = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    sound = sounds.load(this.getApplicationContext(), R.raw.hit, 1);
}


@Override
public boolean onTouch(View arg0, MotionEvent event) {

    switch (event.getAction() ) { 
    case MotionEvent.ACTION_DOWN: 
        System.out.println("touch");
        sounds.play(sound, 1, 1, 1, -1, 1);
        break;
    case MotionEvent.ACTION_UP:
        System.out.println("up");
        sounds.autoPause();
        break; 
    }

    return true;
}