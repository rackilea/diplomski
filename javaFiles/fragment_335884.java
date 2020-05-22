ArrayList<int[]> observed = new ArrayList<int[]>();
for (int j = 0; j< featurevec.length; j++) {
    int[] f = new int[2];
    totalOnes = arraySum(featurevec[j]);
    //total elements - total one count = total zero count
    f[0] = featurevec[j].getNumElements() - totalOnes; 
    f[1] = totalOnes;
    observed.add(f);
}

//not sure of arr's type, unclear from your code, probably Integer?
private int arraySum(ArrayList<T> arr) { 
    int sum = 0;
    //this loop syntax might not work depending on DoubleMatrix's implementation 
    for(int i : arr) 
        sum+=i;
    return sum;
}