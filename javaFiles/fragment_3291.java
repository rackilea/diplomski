public double calcProbability(int n, int d, int x){
        Random random = new Random(); //Random numbers simulate dice rolling
        int occurrences = 0; //No. of times that the number is greater than d
        for(int i=0;i<100000;i++)
        {
            int sum = 0;
            for(int j=0;j<n;j++)
            {
                sum+=random.nextInt(d)+1;
            }
            if(sum>=x) {
                occurrences++;
            }

        }
            return (double)occurrences/100000; //Will be an approximation
    }