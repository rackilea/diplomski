static MediaPlayer playMedia;

private void playGeneric(MediaPlayer mp, int name, Button button) {
    button.setEnabled(false);
    button.setClickable(false);
    if(mp !=null){
      mp.stop();
      mp.release();
    }
    mp = MediaPlayer.create(this, name);
    mp.start();

}

@Override
public void onCompletion(MediaPlayer mp) {
    mp.release();
    playMedia = null;
    button.setEnabled(true);
    button.setClickable(true);
}