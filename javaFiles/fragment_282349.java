public Matrix(double[][] input){
    // stored = Arrays.copyOf(input,input.length); // this would only work for 1D arrays
    stored = new double[input.length][];
    for (int i = 0; i < input.length; i++)
        stored[i] = Arrays.copyOf(input[i],input[i].length);
}