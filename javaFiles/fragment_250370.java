import ddf.minim.analysis.*;
import ddf.minim.*;

Minim       minim;
//AudioInput  in;
AudioPlayer in;
FFT         fft;

float smoothing = 0.60;
final boolean useDB = true;
final int minBandwidthPerOctave = 200;
final int bandsPerOctave = 10;
float[] fftSmooth;
int avgSize;

float minVal = 0.0;
float maxVal = 0.0;
boolean firstMinDone = false;

void setup(){
  minim = new Minim(this);
  //in = minim.getLineIn(Minim.STEREO, 512);
  in = minim.loadFile("C:\\path\\to\\some\\audio\\file.ext", 2048);

  in.loop();

  fft = new FFT(in.bufferSize(), in.sampleRate());

  // Use logarithmically-spaced averaging
  fft.logAverages(minBandwidthPerOctave, bandsPerOctave);

  avgSize = fft.avgSize();
  fftSmooth = new float[avgSize];

  int myWidth = 500;
  int myHeight = 250;
  size(myWidth, myHeight);
  colorMode(HSB,avgSize,100,100);

}

float dB(float x) {
  if (x == 0) {
    return 0;
  }
  else {
    return 10 * (float)Math.log10(x);
  }
}

void draw(){
  background(0);
  stroke(255);

  fft.forward( in.mix);

  final int weight = width / avgSize;
  final float maxHeight = (height / 2) * 0.75;

  for (int i = 0; i < avgSize; i++) {
    // Get spectrum value (using dB conversion or not, as desired)
    float fftCurr;
    if (useDB) {
      fftCurr = dB(fft.getAvg(i));
    }
    else {
      fftCurr = fft.getAvg(i);
    }

    // Smooth using exponential moving average
    fftSmooth[i] = (smoothing) * fftSmooth[i] + ((1 - smoothing) * fftCurr);

    // Find max and min values ever displayed across whole spectrum
    if (fftSmooth[i] > maxVal) {
      maxVal = fftSmooth[i];
    }
    if (!firstMinDone || (fftSmooth[i] < minVal)) {
      minVal = fftSmooth[i];
    }
  }

  // Calculate the total range of smoothed spectrum; this will be used to scale all values to range 0...1
  final float range = maxVal - minVal;
  final float scaleFactor = range + 0.00001; // avoid div. by zero

  for(int i = 0; i < avgSize; i++)
  {
    stroke(i,100,100);
    strokeWeight(weight);

    // Y-coord of display line; fftSmooth is scaled to range 0...1; this is then multiplied by maxHeight
    // to make it within display port range
    float fftSmoothDisplay = maxHeight * ((fftSmooth[i] - minVal) / scaleFactor);

    // X-coord of display line
    float x = i * weight;

    line(x, height / 2, x, height / 2 - fftSmoothDisplay);
  }
  text("smoothing: " + (int)(smoothing*100)+"\n",10,10);
}
void keyPressed(){
  float inc = 0.01;
  if(keyCode == UP && smoothing < 1-inc) smoothing += inc;
  if(keyCode == DOWN && smoothing > inc) smoothing -= inc;
}