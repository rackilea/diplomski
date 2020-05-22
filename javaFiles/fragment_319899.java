float frameRate = 44100f; // 44100 samples/s
int channels = 2;
double duration = 1.0;
int sampleBytes = Short.SIZE / 8;
int frameBytes = sampleBytes * channels;
AudioFormat format =
    new AudioFormat(Encoding.PCM_SIGNED,
                    frameRate,
                    Short.SIZE,
                    channels,
                    frameBytes,
                    frameRate,
                    true);
int nFrames = (int) Math.ceil(frameRate * duration);
int nSamples = nFrames * channels;
int nBytes = nSamples * sampleBytes;
ByteBuffer data = ByteBuffer.allocate(nBytes);
double freq = 440.0;
// Generate all samples
for ( int i=0; i<nFrames; ++i )
{
  double value = Math.sin((double)i/(double)frameRate*freq*2*Math.PI)*(Short.MAX_VALUE);
  for (int c=0; c<channels; ++ c) {
      int index = (i*channels+c)*sampleBytes;
      data.putShort(index, (short) value);
  }
}

AudioInputStream stream =
    new AudioInputStream(new ByteArrayInputStream(data.array()), format, nFrames*2);
Clip clip = AudioSystem.getClip();
clip.open(stream);
clip.start();
clip.drain();