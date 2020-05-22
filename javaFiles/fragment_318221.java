private static int[] sampleSizes = new int[] {8,16,32,64,128,140,160,200,240,280,320,360,400,20000};
private static Random rng = new Random();
private static int numTemps = 20000;
private static double[] allTemps = new double[numTemps]; 
private static double meanTemperature = 500;
private static double deviation = 100;

private static void initTemperatures() {        
    for (int i = 0; i < numTemps; i++) {
        allTemps[i] = meanTemperature + deviation * (rng.nextDouble() - 0.5);
    }
}

public static void main(String[] args) {
    initTemperatures();
    calcEstimates();
}