public class Test {

    public static void main(String[] args) {
        double[][] ori = new double[][] { {1,2,3}, {4,5,6}, {7,8,9}, {10,11,12} };
        double[][] res = reshape(ori,2,6);

        for(int i = 0;i<ori.length;i++){
            for(int j = 0;j<ori[0].length;j++){
                System.out.print(ori[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        for(int i = 0;i<res.length;i++){
            for(int j = 0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println("");
        }



    }

    public static double[][] reshape(double[][] A, int m, int n) {
        int origM = A.length;
        int origN = A[0].length;
        if(origM*origN != m*n){
            throw new IllegalArgumentException("New matrix must be of same area as matix A");
        }
        double[][] B = new double[m][n];
        double[] A1D = new double[A.length * A[0].length];

        int index = 0;
        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<A[0].length;j++){
                A1D[index++] = A[i][j];
            }
        }

        index = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                B[j][i] = A1D[index++];
            }

        }
        return B;
    }
}