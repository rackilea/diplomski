for (int i=0; i<sampleArray.length; i+=44) {
    if (findOver18KHz(sampleArray, i, i++44)) {
        // found tone over 18KHz
    }
}

/**
 * Check for a tone over 18KHz
 */
boolean findOver18KHz(int[] samples, start, end) {
  // call the FFT stuff
  // make sure you don't get an ArrayOutOfBoundsException for samples.
}