package com.mytest.ndktest;

public class FrequencySample {
    private static int _AMP = 10000;
    private static double _TWO_PY = 8. * Math.atan(1.);
    private static double _PHASE = 0.0;
    private static short[] _SAMPLE_BUFFER; 

    /* Creates a frequency sample
     * Stores frequency samples in a sample buffer 
     */
    public static short[] buildJ(int freq, int sampleRate, int bufferSize) {        
        _SAMPLE_BUFFER = new short[bufferSize]; 
        for(int i = 0; i < bufferSize; i++){
            _SAMPLE_BUFFER[i] = (short) (_AMP * Math.sin(_PHASE));
            _PHASE += _TWO_PY * freq / sampleRate;
        } 
        return _SAMPLE_BUFFER;
    }

    public static native short[] buildN(int freq, int sampleRate, int bufferSize);

    static {
        System.loadLibrary("ndktest");
    }
}