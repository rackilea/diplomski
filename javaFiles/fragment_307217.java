public void error_sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    AudioInputStream AIS = ...
    AudioFormat format = ...
    SourceDataLine playbackLine = ...
    playbackLine.open(format);
    playbackLine.start();

    int repeats = 5;
    while (true) {
       // playloop
       int bytesRead = 0;
       byte[] buffer = new byte[128000];
       while (bytesRead != -1) {
           bytesRead = AIS.read(buffer, 0, buffer.length);
           if (bytesRead >= 0)
                playbackLine.write(buffer, 0, bytesRead);
       }
       --repeats;
       if (repeats <= 0) {
           // done, stop playing
           break;
       } else {
           // repeat one more time, reset audio stream
           AIS = ...
       }
   }
   playbackLine.drain();
   playbackLine.close();
}