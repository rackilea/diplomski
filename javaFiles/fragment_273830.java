public static int[] split(int num){
        int[] splits = new int[31]; 
        for(int i=0; i < 31; ++i){
            splits[i] = (num>>i & 1);
        }
        return splits;
    }

    static void cpuTurn(int[] nimArray){
        int[] val = new int[nimArray.length];
        int holding = 0;
        int [] holdings = split(holding);
        for (int i = 0; i < nimArray.length; i++) {
            int [] splits = split(nimArray[i]);
            for(int j = 0; j < splits.length; ++j)
                 holdings[j]+=splits[j]
        }

        int [] newVal = new int[31];
        int k =0;
        for(k = 0; k < 31; ++k)
            if(holdings[k]>1 || holdings[k]==0)
                newVal[k] = 0;
            else
                newVal[k] = 1;

        int finalValue = 0;
        for(k = 0; k < 31; ++k)
             finalValue |= newVal[k]<<k;

        System.out.println(finalValue);

    }