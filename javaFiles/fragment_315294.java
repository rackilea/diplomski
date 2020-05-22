public static double randomFunctions(int maxDepth, double x, double y) {
    MathFunction[] functions = {new Cosine(), new Sine(), new Tangent()}; 

    int currX = x;
    int currY = y;

    // repeatedly apply functions to each value randomly
    for (int i = 0; i < maxDepth; i++) {
        Random r = new Random();
        currX = r.nextInt(functions.length - 1);
        currY = r.nextInt(functions.length - 1);
    }

    // randomly return one of the two numbers
    Random r = newRandom();
    if (r.nextBoolean()) {
        return currX;
    } else {
        return currY;
    }
}