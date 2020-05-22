class AudioPlayer implements Runnable
{
    AudioInputStream input;
    Clip clip;
    private boolean running;

    public AudioPlayer(String path)
    {
        running = true;
        try
        {
            clip = AudioSystem.getClip();
            input = AudioSystem.getAudioInputStream(new File(path));
            clip.open(input);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            System.out.println(e);
        }
    }    
    public void play()
    {        
        clip.loop(1);
        running = true;
    }
    public void stop()
    {
        running = false;
        clip.stop();        
    }
    public void loop()
    {
        running = true;        
        new Thread(this).start();
    }
    public void suspend()
    {
        running = false;
    }
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(2);
        }
        catch(InterruptedException e)
        {

        }
        while(running)
        {
            clip.loop(1);
        }
    }
}