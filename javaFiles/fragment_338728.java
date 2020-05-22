import static java.lang.System.out;
public class Playground {

    public static void main(String [] args) {
        int [][] array = { {4,2},{1,7},{4,5},{1,2},{1,1},{4,1}};
        sort(array);
        print(array);
    }

    public static void print(int [][] m) {
        for (int i = 0; i < m.length ; i++) {
            if (i > 0) {
                out.print(",");
            }
            out.print( "{"+ m[i][0] + "," + m[i][1] + "}");
        }
        out.println();
    }

    public static void sort(int A [][] ) {
        boolean unsorted = true;
        while (unsorted) {
            unsorted = false;
            for (int i =0 ; i < A.length -1; i ++) {
                if ( ( A[i][0] > A[i+1][0] )
                || ( (A[i][0] == A[i+1][0] )
                &&   (A[i][1] > A[i+1][1]    )
                   )) {
                    int [] temp = new int[2];
                    temp[0] = A[i][0];
                    temp[1] = A[i][1];
                    A[i][0] = A[i+1][0];
                    A[i][1] = A[i+1][1];
                    A[i+1] = temp;
                    unsorted = true;
                }
            }
        }
    }
}