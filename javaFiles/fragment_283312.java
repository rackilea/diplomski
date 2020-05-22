void cycle() 
  throws InterruptedException 
{
  int endPoint = LevelStructure.getChunkTotal();
  for (int chunk = 0; chunk < endPoint; chunk++) {
    LevelStructure.setActiveChunk(chunk);
    for (int quartBeat = 0; quartBeat < 64; quartBeat++) {
      long start = System.nanoTime();
      Player.playback(LevelStructure.getQuartBeat(quartBeat));
      long delay = 15_000_000_000L / BPM - (System.nanoTime() - start);
      if (delay < 0)
        throw new IllegalStateException("Allotted time exceeded");
      if (delay > 0)
        Thread.sleep(delay / 1_000_000, delay % 1_000_000);
    }
  }
}