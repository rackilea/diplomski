public class MyClass {
    public static void main(String args[]) {
        int[][] x= {{1,2},{3,4,5},{6,7}};
        for (int i = 0; i < x[0].length; i++){
            for (int j = 0; j < x[1].length; j++){
                for(int k = 0; k < x[2].length; k++){
                    System.out.println(x[0][i] + " " + x[1][j] + " " + x[2][k]);
                }
            }
        }
    }
}