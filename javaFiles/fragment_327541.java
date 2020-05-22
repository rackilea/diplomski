double[] median = new double[inData.size()];

for (int i=0; i < inData.size(); i++) {
    String[] word = inData.get(i).split(", "); 
    double m = Double.parseDouble(word[3].substring (0,5));
    median[i] = m;
}

Arrays.sort(median);