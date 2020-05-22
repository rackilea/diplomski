public double getMode(double[] numberList) {
    HashMap<Double,Double> freqs = new HashMap<Double,Double>();
    for (double d: numberList) {
        Double freq = freqs.get(d);
        freqs.put(d, (freq == null ? 1 : freq + 1));   
    }
    double mode = 0;
    double maxFreq = 0;    
    for (Map.Entry<Double,Doubler> entry : freqs.entrySet()) {     
        double freq = entry.getValue();
        if (freq > maxFreq) {
            maxFreq = freq;
            mode = entry.getKey();
        }
    }    
    return mode;
}