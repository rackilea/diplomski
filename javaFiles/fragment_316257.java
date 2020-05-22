public class Lab6{
    static int[][] g= new int[][] {{0, 1, 2} , {1, 0, 3} , {2, 3, 0}};
    static int[][] lecExample = new int[][] {{0, 1, 2, 3, 0} , {1, 0, 6, 0, 5} , {2, 6, 0 ,4, 1} , {3, 0, 4, 0, 2} , {0, 5, 1, 2, 0}};


    public static void main(String[] args){
        displayArray(g);
        displayArray(MST.PrimMST(g));
        displayArray(lecExample);
        displayArray(MST.PrimMST(lecExample));

        int[][] randomArray = getRandomArray(50);
        displayArray(randomArray);
        displayArray(MST.PrimMST(randomArray));
    }

    public static int[][] getRandomArray(int n){
        int[][] a = new int[n][n];
        Random r = new Random();

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                a[i][j] = r.nextInt();
            }
        }

        return a;
    }

    public static void displayArray(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(" " + a[i][j]);
            }
            System.out.println("");
        }
    }
}