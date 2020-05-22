double examMarks [] = {50,40,60,80,70,11};
    double courseworkmarks [] = {65,49,58,77,35,40};

    double avgMarks[] =new double[examMarks.length];

    for(int i=0;i<avgMarks.length;i++){
        avgMarks[i]=(examMarks[i]+courseworkmarks[i])/2;
    }