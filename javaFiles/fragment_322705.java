public class AudioAnalyzer {
    private IIRFilter bandpass, lowpass;
    final double[] b1 = {0.0286, 0, -0.0859, 0, 0.0859, 0, -0.0286}; 
    final double[] a1 = {-3.9320, 6.8170, -6.7455, 4.0453, -1.3889, 0.2120};

    public AudioAnalyzer() {
        bandpass = new IIRFilter(b1, a1);
    }

    public boolean analyze(double[] inputFilter, double[] outputFilter) {
        int i;
        double g1[] = new double[inputFilter.length];

        for (i = 0; i < inputFilter.length; i++) {
            double f1 = inputFilter[i];
            g1[i] = outputFilter[i]-(bandpass.filter(f1));

        for (i = 0; i < g1.length; i++){
            if (( g1[i]-outputFilter[i] != 0))
                return false;
        }


         return true;
     }
}