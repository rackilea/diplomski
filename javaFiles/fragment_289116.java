public class Distribution {
    private Double[] data;
    private double max = Double.NaN;
    private double min = Double.NaN;
    private double variance = Double.NaN;
    private double average = Double.NaN;        

    public getMax() {
        if( max == Double.NaN ) {
            calculateStats();
        }
        return max;
    }

    // each method getMin, getAverage, getVariance, etc would be written the same way as getMax().

    private void calculateStats() {
        min = Double.MAX_VALUE;
        max = Double.MIN_VALUE;
        average = 0;
        variance = 0;
        for( int i = 0; i < data.length; i++ ) {
            double sample = data[i];
            if( sample > max ) max = sample;
            if( sample < min ) min = sample;
            average += sample;
            variance += sample * sample;
        }

        average = average / data.length;
        variance = variance / data.length - average * average;
    }

    public double getStandardDeviation() {
        if( variance == Double.NaN ) {
            calculateStats();
        }
        return Math.sqrt( variance );
    }
}