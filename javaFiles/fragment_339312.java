import java.util.*;

public class arrays {
    public static void main(String args[]) {

        int[] array = new int[10];
        int number = Integer.MAX_VALUE;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter starting number: ");


        try{
            number = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Invalid input detected - Not an integer");
            System.exit(0);
        }       

        for(int i = 0; i < array.length; ++i) {

            if(number % 2 == 0){
                array[i] = (number + 2) + (2 * i);
            }else{
                array[i] = (number + 1) + (2 * i);
            }

            if(number > array[i]){
                System.out.println("Invalid input detected - overflow of type int!");
                Arrays.fill(array, 0);
                System.exit(0);
            }
        }

        System.out.println(Arrays.toString(array));
    }
}