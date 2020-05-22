@Override
  protected void onResume() {
    super.onResume();
   Uri videoUri =Uri.fromFile(new File("/storage/extSdCard/Download/great.mp4")) 
    //set the uri of the video to be played 
    video.setVideoURI(videoUri);
    video.start();

    video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.setLooping(true);
        }
    });
}