if(true)
  {
     File file = new File("GodzillaWAV.wav");
     Clip clip = AudioSystem.getClip();
     AudioInputStream Audio = AudioSystem.getAudioInputStream(file);
     clip.open(Audio);
     clip.loop(Clip.LOOP_CONTINUOUSLY);
     Thread.sleep(6000);
  }