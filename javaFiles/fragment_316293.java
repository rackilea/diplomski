public void onClick(View v) {
    int resId = 1;
    // Release any resources from previous MediaPlayer
    if (mp != null) {               
        mp.release();   
    }

    // Create a new MediaPlayer to play this sound
    mp = MediaPlayer.create(this, resId); 
    mp.start();

    switch (v.getId()) {
      case R.id.button_4: resId = R.raw.button_4; break;
      case R.id.button_5: resId = R.raw.button_5; break;
    }

}