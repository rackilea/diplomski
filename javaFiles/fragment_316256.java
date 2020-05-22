public static void randomArray(int n){

    n = 0;

    double[][] array = new double[][] {{n, n, n, n, n}, {n, n, n, n, n}, {n, n, n, n, n}, {n, n, n, n, n}, {n, n, n, n, n}};
    double mst3[][] = MST.PrimsMST(array);