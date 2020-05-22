nextTrack.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
      mp.stop();
      mp.reset();
      mp.setDataSource(audioArray[currentIndex + 1]);
      mp.prepare();              
      mp.start();
   }