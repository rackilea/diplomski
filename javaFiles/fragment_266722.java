//compute averages
double[] sums = new double[size];
double[] averages = new double[size];

for (Entry<Integer, double[]> entry : cachedWeights.entrySet()) {
    double[] value = entry.getValue();
    for(int pos=0; pos < Math.min(size, value.length); pos++){
        sums[pos] +=  value[pos]; 
    }
}
for(int pos=0; pos < size; pos++){
    averages[pos] = sums[pos] / cachedWeights.size(); 
}