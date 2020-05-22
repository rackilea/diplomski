for (int i=0;i<20;i++) {
        if(counter == 0) {
            pi -= (double) 4/num[i];
            counter++;
        }else {
            pi += (double) 4/num[i];
            counter--;
        }
    }