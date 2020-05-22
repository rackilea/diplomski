int max = -1;
    int maxIndex = -1;
    for(int i = 0; i < deltagare; i++) {
        max = -1; // clear the max value when starting with a new member
        maxIndex = -1;
        for(int t = 0; t < domare; t++) {
            if (poängInsamling[t][i] > max) {
                max = poängInsamling[t][i];
                maxIndex = t;
            }       
        }
        // clear the max value for the current member
        poängInsamling[maxIndex][i] = -1;
    }