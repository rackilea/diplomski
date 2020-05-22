import ddf.minim.analysis.*;
import ddf.minim.*;

Minim       minim;
//AudioInput  in;
AudioPlayer in;
FFT         fft;

float smoothing = 0.73;
final boolean useDB = true;
final boolean useAWeighting = true; // only used in dB mode, because the table I found was in dB 
final boolean resetBoundsAtEachStep = false;
final float maxViewportUsage = 0.85;
final int minBandwidthPerOctave = 200;
final int bandsPerOctave = 10;
final float maxCentreFrequency = 18000;
float[] fftSmooth;
int avgSize;

float minVal = 0.0;
float maxVal = 0.0;
boolean firstMinDone = false;

final float[] aWeightFrequency = { 
  10, 12.5, 16, 20, 
  25, 31.5, 40, 50, 
  63, 80, 100, 125, 
  160, 200, 250, 315, 
  400, 500, 630, 800, 
  1000, 1250, 1600, 2000, 
  2500, 3150, 4000, 5000,
  6300, 8000, 10000, 12500, 
  16000, 20000 
};

final float[] aWeightDecibels = {
  -70.4, -63.4, -56.7, -50.5, 
  -44.7, -39.4, -34.6, -30.2, 
  -26.2, -22.5, -19.1, -16.1, 
  -13.4, -10.9, -8.6, -6.6, 
  -4.8, -3.2, -1.9, -0.8, 
  0.0, 0.6, 1.0, 1.2, 
  1.3, 1.2, 1.0, 0.5, 
  -0.1, -1.1, -2.5, -4.3, 
  -6.6, -9.3 
};

float[] aWeightDBAtBandCentreFreqs;

void setup(){
  minim = new Minim(this);
  //in = minim.getLineIn(Minim.STEREO, 512);
  in = minim.loadFile("D:\\Music\\Arthur Brown\\The Crazy World Of Arthur Brown\\1-09 Fire.mp3", 2048);

  in.loop();

  fft = new FFT(in.bufferSize(), in.sampleRate());

  // Use logarithmically-spaced averaging
  fft.logAverages(minBandwidthPerOctave, bandsPerOctave);
  aWeightDBAtBandCentreFreqs = calculateAWeightingDBForFFTAverages(fft);

  avgSize = fft.avgSize();
  // Only use freqs up to maxCentreFrequency - ones above this may have
  // values too small that will skew our range calculation for all time
  while (fft.getAverageCenterFrequency(avgSize-1) > maxCentreFrequency) {
    avgSize--;
  }

  fftSmooth = new float[avgSize];

  int myWidth = 500;
  int myHeight = 250;
  size(myWidth, myHeight);
  colorMode(HSB,avgSize,100,100);

}

float[] calculateAWeightingDBForFFTAverages(FFT fft) {
  float[] result = new float[fft.avgSize()];
  for (int i = 0; i < result.length; i++) {
    result[i] = calculateAWeightingDBAtFrequency(fft.getAverageCenterFrequency(i));
  }
  return result;    
}

float calculateAWeightingDBAtFrequency(float frequency) {
  return linterp(aWeightFrequency, aWeightDecibels, frequency);    
}

float dB(float x) {
  if (x == 0) {
    return 0;
  }
  else {
    return 10 * (float)Math.log10(x);
  }
}

float linterp(float[] x, float[] y, float xx) {
  assert(x.length > 1);
  assert(x.length == y.length);

  float result = 0.0;
  boolean found = false;

  if (x[0] > xx) {
    result = y[0];
    found = true;
  }

  if (!found) {
    for (int i = 1; i < x.length; i++) {
      if (x[i] > xx) {
        result = y[i-1] + ((xx - x[i-1]) / (x[i] - x[i-1])) * (y[i] - y[i-1]);
        found = true;
        break;
      }
    }
  }

  if (!found) {
    result = y[y.length-1];
  }

  return result;     
}

void draw(){
  background(0);
  stroke(255);

  fft.forward( in.mix);

  final int weight = width / avgSize;
  final float maxHeight = height * maxViewportUsage;
  final float xOffset = weight / 2 + (width - avgSize * weight) / 2;

  if (resetBoundsAtEachStep) {
    minVal = 0.0;
    maxVal = 0.0;
    firstMinDone = false;
  }

  for (int i = 0; i < avgSize; i++) {
    // Get spectrum value (using dB conversion or not, as desired)
    float fftCurr;
    if (useDB) {
      fftCurr = dB(fft.getAvg(i));
      if (useAWeighting) {
        fftCurr += aWeightDBAtBandCentreFreqs[i];
      }
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
    // Artificially impose a minimum of zero (this is mathematically bogus, but whatever)
    fftSmoothDisplay = max(0.0, fftSmoothDisplay);

    // X-coord of display line
    float x = xOffset + i * weight;

    line(x, height, x, height - fftSmoothDisplay);
  }
  text("smoothing: " + (int)(smoothing*100)+"\n",10,10);
}
void keyPressed(){
  float inc = 0.01;
  if(keyCode == UP && smoothing < 1-inc) smoothing += inc;
  if(keyCode == DOWN && smoothing > inc) smoothing -= inc;
}