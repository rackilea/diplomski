private static double[][] RandomArray(int n) {
        double[][] randomMatrix = new double [n][n];
        double[] randomArray = new double [n];
         Random rand = new Random(); 
            rand.setSeed(System.currentTimeMillis()); 

        for (int i = 0; i < n; i++) {   

            for (int j = 0; j < n; j++) {
                Integer r = rand.nextInt()% 100; 
                randomMatrix[i][j] = Math.abs(r);
            }

        }

        return randomMatrix;
    }


public static void main(String[] args){

        //PrintRandomGraph(RandomArray(5));
    System.out.println(Arrays.deepToString(RandomArray(5)));
}