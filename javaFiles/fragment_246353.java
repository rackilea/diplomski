class Test {

    public static void main(String [ ] args) {
            double[] scores = {3, 9, 3, 3};
            double[] scoresSquared = squareArray(scores);
            for (int i =0; i <scoresSquared.length; i++) {
                    System.out.println(scoresSquared[i] + " ");
            }
    }

    public static double[] squareArray(double[] dArray){
            double[] squareArray = new double[dArray.length];
            for (int i = 0; i < dArray.length ; i++){
                    squareArray[i]= dArray[i] * dArray[i];
            }
            return squareArray;
    }
}