public void PlaySound(String fileName){
    int sound_id = context.getResources().getIdentifier(fileName, "raw",
                                                 context.getPackageName());
    if(sound_id != 0) {
      mediaPlr = MediaPlayer.create(context, sound_id);
      mediaPlr.start();
    }
}