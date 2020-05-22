public class Array3 {

public static void main(String[] args) {


    int[] numbers = {1, 5, 2, 6, 3, 8, 9, 4, 7};
    int temp = 0;       

    //Remove the equal operator in first for loop   
    for(int i = 0 ; i < numbers.length - 1 ; i++) {  
     //Remove the equal operator in second for loop                      
        for (int j = 0 ; j < numbers.length - 1 - i; j++) {
            if(numbers[j] > numbers[j + 1]) { //error is in this line
                temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
            }
        }
    }
   // you should use number[i],and remove '=' operator or use -1 here.
    for(int i = 0 ; i < numbers.length ; i++) {
        System.out.print(numbers[i] + ", ");
    }
}
}