int min = ratioArray[0];
        int minindex;
        for (int i = 0; i < ratioArray.length; i++) {
            if(min > ratioArray[i]) {
 min = ratioArray[i];
                minindex = i;
            }
        }