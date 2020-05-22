public Clip loadClip( String filename )
{
    Clip clip = null;

    try
    {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream( getClass().getResource( filename ) );
        clip = AudioSystem.getClip();
        clip.open( audioIn );
    }
    catch( Exception e )
    {
        e.printStackTrace();
    }

    return clip;
}