@Override
public void onClick(View v) {
    Button b = (Button)v;
    String note = b.getText().toString().toLowerCase();
    play(note);
}

public void play(String note){
  try {
    mp = MediaPlayer.create(this,getResources().getIdentifier(note,"raw", getPackageName()));
    mp.start();
  } catch (Exception e) {
     Log.e("Error", "error playing file with name : " + note + "\n" + e);
  }

}