public float[] loadSoundFileURL(URL url) throws UnsupportedAudioFileException,
        IOException
{
    AudioInputStream ais = AudioSystem.getAudioInputStream(url);

    int framesCount = (int)ais.getFrameLength();

    // assuming stereo format, so two entries per frame
    float[] temp = new float[framesCount * 2];
    long tempCountdown = temp.length;

    int bytesRead = 0;
    int bufferIdx;
    int clipIdx = 0;
    byte[] buffer = new byte[1024];
    while((bytesRead = ais.read(buffer, 0, 1024)) != -1)
    {
        bufferIdx = 0;
        for (int i = 0, n = (bytesRead >> 1); i < n; i ++)
        {
            if ( tempCountdown-- >= 0)
            {
                temp[clipIdx++] = 
                        ( buffer[bufferIdx++] & 0xff )
                        | ( buffer[bufferIdx++] << 8 ) ;
            }
        }
    }

    // QUESTION: better to do following in above loop?
    for (int i = 0; i < temp.length; i++)
    {
        temp[i] = temp[i] / 32767f;
    }

    return temp;
}