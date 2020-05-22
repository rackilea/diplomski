import java.util.Scanner;


public class NewClass {

public static void main(String [] args) {

    Scanner scan = new Scanner(System.in);

    int i = 0, count1 = 0, count0 = 0;
    String number;

    char number1 = '0';
    char number2 = '1';

    int total;

    while(true){
        System.out.println("Please enter a binary number.");
        number = scan.nextLine();

        char [] charArray = number.toCharArray();

        while(i < charArray.length){

            if(charArray[i] == number1){
                count0++;
            } else if(charArray[i] == number2) {
                count1++;
            }
            i++;
        }

        total = count0 + count1;

        if(charArray.length == total){

            System.out.println("There are " + count0 + " zeros in the binary number.");
            System.out.println("There are " + count1 + " ones in the binary number.");
            break;

        } else {
            System.out.println("ERROR: Not a binary number.");
        }


    }
  }
}