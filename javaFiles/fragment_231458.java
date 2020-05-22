for(int i=1; i<=nrweek; i++){

    int min = Integer.MAX_VALUE; // initialising
    int max = Integer.MIN_VALUE; // initialising

    for(int j=1; j<=nrofmeasureperweek; j++){
        // min of current number and the min we have seen till now
        min = Math.min(min, t[i][j]); 
        // similar for max
        max = Math.max(max, t[i][j]);
    }

    minT[i] = min;
    maxT[i] = max; // storing back the min and max
}