package arrays_into_2d_array;

import java.util.*;

public class Arrays2DArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random random = new Random();
        int [] sizes = {50, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600};
        int [][] arr2D = new int[sizes.length][];
        for(int i = 0; i < arr2D.length; i++){
            arr2D[i] = new int[sizes[i]];
            for(int j = 0; j < arr2D[i].length; j++){
                arr2D[i][j] = 1+random.nextInt(5);
            }
        }

        for(int i = 0; i < arr2D.length; i++){
            System.out.println("Index = "+i+" of 2D array has = "+arr2D[i].length+" number of elements.");
        }

    }

}