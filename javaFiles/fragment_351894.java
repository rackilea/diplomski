float[] rndX = new float[10];
    float[] rndY = new float[10];

    int width = 100;
    int height = 100;

    Random generator = new Random(System.currentTimeMillis());

    for(int i=0;i<rndX.length;i++){
       rndX[i] = (float)generator.nextInt(width);
       rndY[i] = (float)generator.nextInt(height);
    }