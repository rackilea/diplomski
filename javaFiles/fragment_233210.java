public long sumDouble(){

        double[] arr = new double[1000];
        for(int i = 0 ;i < 1000;i++){
            arr[i]=new Random().nextFloat();
        }
        float sum = 0.0f;
        long start = System.currentTimeMillis();
        for(int i = 0 ;i < 1000;i++){
            sum+=arr[i];
        }
        System.out.println(""+sum);
        long end = System.currentTimeMillis();
        return end - start;
    }
    public long sumFloat(){

        double[] arr = new double[1000];
        for(int i = 0 ;i < 1000;i++){
            arr[i]=new Random().nextDouble();
        }
        double sum = 0.0f;
        long start = System.currentTimeMillis();
        for(int i = 0 ;i < 1000;i++){
            sum+=arr[i];
        }
        System.out.println(""+sum);
        long end = System.currentTimeMillis();
        return end - start;
    }