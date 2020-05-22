int upperround45(int i) {
    int temp = i%45;
    //For the algorithm we wish the rest to be how much more than last multiple of 45.
    if (temp < 0 ) 
        temp = 45 + temp;
    if (temp == 0) {
        return i;
    } else {
        return i + 45 - temp;
    }
}