public static synchronized void playSound(final File file) 
{
new Thread(new Runnable() 
{ 
    @Override
  public void run() 
  {
    try 
    {

      AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
      Clip clip = AudioSystem.getClip();
      clip.open(inputStream);
      clip.start(); 
    } catch (Exception e) 
    {

      System.err.println(e.getMessage());
    }
  }
}
        )
        .start();
}