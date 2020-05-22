for(int q=0; q<range; q++){

        b3= term2[many-1]-term2[many-2];
        b2= term2[many-2]-term2[many-3];
        b1= term2[many-3]-term2[many-4];

        c2= b3-b2;
        c1= b2-b1;

        d= c2-c1;

        int result= term2[many-1]+b3+c2+d;

        System.out.println(result);

        term2[many] = result;  // you forgot this update
        many++;     
    }