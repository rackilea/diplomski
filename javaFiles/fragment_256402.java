int range_min = 1, range_max = 4;

    int[] input        = {1, 2, 1, 3, 4, 2, 1, 3, 2, 3, 1, 4, 2};
    int[] output       = new int[input.length];
    int[] intermediate = new int[range_max-range_min+1];

    for(int num : input)                        
        intermediate[num-range_min]++;

    int cnt = 0;
    for(int i=0; i<range_max-range_min+1; i++)  
        for(int j=0; j<intermediate[i]; j++)
            output[cnt++] = i+range_min;