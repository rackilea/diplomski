ImageView seethrough;    

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
seethrough = (ImageView) findViewById(R.id.Seethrough);
seethrough.setOnTouchListener(this);
}

@Override
public boolean onTouch(View v, MotionEvent event) {

    ImageView view = (ImageView) v;
switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                 if (mp != null) {
                 mp.stop();
                 mp.release();
                 }
                 mp = MediaPlayer.create(this, R.raw.dry);
                 mp.start();
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_CANCEL:
                    break;
            }
    return true;
}