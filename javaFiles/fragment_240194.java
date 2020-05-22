public class PlaySong extends Thread
{
    Clip clip=null;

    public PlaySong()
    {
        start();
    }

    @Override
    public void run()
    {
        playSound("fax.wav");

        for(;;)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {

            }
        }
    }

    public void playSound(String name)
    {
        try
        {
            File file = new File(this.getClass().getResource(name).getFile());
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}