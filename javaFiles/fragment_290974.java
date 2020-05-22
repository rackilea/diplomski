@Override
public void onPause() {
    super.onPause();  // Always call the superclass method first

    // Release any resources from previous MediaPlayer
        if (mp != null) {               
            mp.release();   
        }
}