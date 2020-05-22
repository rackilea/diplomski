private double constrain(double val, int low, int high) {
    if (val < low)
        return low;
    if (val > high)
        return high;
    return val; // <- notice here
}

public void setMarks(double[] s) {
     for(int i = 0; i < s.length; i++) {
           this.scores[i] =  constrain(s[i], 0, 100); // <- notice here
    }
}