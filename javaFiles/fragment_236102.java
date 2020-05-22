public Kernel getKernel() {
  double sigma = calculateSigma(waveLength, bandwidth);
  float[] data = new float[width*height];
  for(int k = 0, x = -width/2; x <= width/2; x++) {
     for(int y = -height/2; y <= height/2; y++) {
        for(double orientation : orientations) {
           double x1 = x*Math.cos(orientation) + y*Math.sin(orientation);
           double y1 = -x*Math.sin(orientation) + y*Math.cos(orientation);
           data[k] += (float)(gaborFunction(x1, y1, sigma, aspectRatio, waveLength, phaseOffset));
        }
        k++;
     }
  }