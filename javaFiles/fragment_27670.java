private static void playJavaSound(IAudioSamples aSamples)
 {
 /**
 * We're just going to dump all the samples into the line.
 */
 byte[] rawBytes = aSamples.getData().getByteArray(0, aSamples.getSize());
 mLine.write(rawBytes, 0, aSamples.getSize());
 }

private static void closeJavaSound()
{
 if (mLine != null)
{
  /*
   * Wait for the line to finish playing
   */
  mLine.drain();
  /*
   * Close the line.
   */
  mLine.close();
  mLine=null;
  }
 }
}