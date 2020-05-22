1.Your logic is good enough but you can optimize your code by removing some extra loops.
2.If you want to access only diagonal elements then you don't need to run 2 loops.
3.You can do like this

package test.code;
import java.util.Arrays;

public class DiagonalSort {
   static int sortDiagonal(int m[][]) {

     int[] intArray = new int[4];

//to insert 2d array diagonal elements into 1d array
     for(int i = 0; i<m.length; i++){
         intArray[i] = m[i][i];
     }

     // sorting 1d array elements
     Arrays.sort(intArray);

     // inserting sorted elements to its appropriate positions
     for(int i = 0; i<m.length; i++){
         m[i][i]= intArray[i];
     }


     //printing the diagonal elements
     for (int i = 0; i < m.length; i++) { 
            for (int j = 0; j < m[i].length; j++) 
                System.out.print(m[i][j] + " "); 
            System.out.println(); 
        } 
    return 0;

 }

 public static void main(String args[]) 
    { 
        int m[][] = { { 36, 10, 24, 8 }, 
                      { 12, 23, 0,  2 }, 
                      { 9,  5,  10, 2 }, 
                      { 6,  3,  1,  2 } }; 
        sortDiagonal(m); 
    } }