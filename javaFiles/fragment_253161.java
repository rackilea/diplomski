import java.util.Scanner;

    public class Polynomial {
        int[] polyArr; 

        Polynomial(int[] arr) {
            //taking an array as argument in the constructor
            polyArr = new int[arr.length];   //create your polyArr of the same
                                             //length as array in argument 
            for(int i = 0;i < arr.length;i++) {
                polyArr[i] = arr[i];
            }
        }

        public static Polynomial add(Polynomial p1, Polynomial p2) {
            int[] arr = new int[p1.polyArr.length];
            for(int i = 0;i < arr.length;i++) {
                arr[i] = p1.polyArr[i] + p2.polyArr[i];  // merge the two polynomials data in 
                                                        //one array
            }
            return new Polynomial(arr);                 //pass that array while creating new Polynomial 
                                                        //object.
        }

        public static void main(String[] args) {
            //this way you can give you input. Index 0,1,2,3 representing x0, x1, x2, x3 respectively
            int arr[] = {1,2,3,4};
            Polynomial poly = new Polynomial(arr);
        }
    }