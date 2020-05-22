short[]x = new short[]{32, 203, 98, 19, 47, 78}; 
short[]y = new short[x.length]; 

for (int i = 0; i < x.length; ++x)
    if (x[i] % 2 == 0)  // % is the remainder operator 
        y[i] = 0;
    else
        y[i] = 1;