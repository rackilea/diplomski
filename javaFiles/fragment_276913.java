import java.util.Scanner;

public class TestArray {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 5");
        int number = input.nextInt();    

        System.out.println("Now enter " + number +  " names");    
        //NOTE:  You may want to remove this line since it will mess up your data.
        //String names = input.next();

        String[] nameList = new String[number];

        for(int i = 0; i < number; i++){
            nameList[i] = input.next();
        }

        //print separate here.
        System.out.println("Here are the names you entered:  ");
        for(int i = 0; i<number; i++){
            System.out.println(nameList[i]);
        }
    }
}