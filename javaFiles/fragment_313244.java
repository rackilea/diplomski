public static int squaredNumberInRange(int lowerBound, int upperBound){
    double lowerRoot = Math.sqrt(lowerBound);
    double upperRoot = Math.sqrt(upperBound);

    lowerRoot = Math.ceil(lowerRoot);
    upperRoot = Math.floor(upperRoot);

    int spread = (int)upperRoot - (int)lowerRoot + 1;

    return spread;
}