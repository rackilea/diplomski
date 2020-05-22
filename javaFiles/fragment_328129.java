try
{
    //don't try and do things with a null object!
    if (as != null)
    {
        AudioPlayer.player.stop(as);
    }
    System.out.println("stopping");
}
catch (IOException e)
{
    System.err.println(e);
}