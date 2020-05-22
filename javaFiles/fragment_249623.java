public void setMarks(double[] s) {
     for(int i = 0; i < s.length; i++) {
        if (s[i] < 0 || s[i] > 100)
            this.scores[i] = constrain(s[i], 0, 100); // <- this solves!
        else
            this.scores[i] = s[i];
    }
}