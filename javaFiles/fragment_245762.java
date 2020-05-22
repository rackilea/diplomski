public class Sound 
{   
    private boolean isPlaying = false;
    private AdvancedPlayer player = null;

    public Sound(String path) throws Exception 
    {
        InputStream in = (InputStream)new BufferedInputStream(new FileInputStream(new File(path)));
        player = new AdvancedPlayer(in);
    }

    public Sound(String path,PlaybackListener listener) throws Exception 
    {
        InputStream in = (InputStream)new BufferedInputStream(new FileInputStream(new File(path)));
        player = new AdvancedPlayer(in);
        player.setPlayBackListener(listener);
    }

    public void play() throws Exception
    {
        if (player != null) 
        {
            isPlaying = true;
            player.play();
        }
    }

    public void play(int begin,int end) throws Exception 
    {
        if (player != null) 
        {
            isPlaying = true;
            player.play(begin,end);
        }
    }

    public void stop() throws Exception 
    {
        if (player != null)
        {
            player.stop();
            isPlaying = false;

        }
    }

    public boolean isPlaying() 
    {
        return isPlaying;
    }

    public static void main(String[] args) 
    {
        System.out.println("lecture de son");
        try 
        {
            Sound sound = new Sound("C:/Documents and Settings/cngo/Bureau/Stage-Save/TCPIP_AndroidJava/TCPIP_V6_Sound/OpeningSuite.mp3");
            System.out.println("playing : " + sound.isPlaying());
            sound.play();
            System.out.println("playing : " + sound.isPlaying());
        } 
        catch (Exception e){e.printStackTrace();}
    }
}