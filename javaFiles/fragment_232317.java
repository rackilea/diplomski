public void PlaySound(View view) {

    if(clickSound.isPlaying()) {
        clickSound.stop();
    }
    else{
        clickSound.setLooping(true);
        clickSound.start();
    }
}