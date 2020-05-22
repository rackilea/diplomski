AssetFileDescriptor afd = getApplicationContext ().getResources ().openRawResourceFd (R.raw.sound);

if (afd != null)
{
    mediaPlayer.reset()
    mediaPlayer.setDataSource(afd.getFileDescriptor (), afd.getStartOffset (), afd.getLength ());
    mediaPlayer.setLooping (true);
    mediaPlayer.prepare ();
    mediaPlayer.start ();
}