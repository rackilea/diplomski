import java.util.Scanner;

public class Main {

//only declaration and initialization outside methods

public static void main(String a[]){

    Scanner input = new Scanner(System.in);
    int total = 0;
    int grade;
    int average = 0;
    int counter = 0; 

    while (counter<10) {
        grade = input.nextInt();
        total += grade;
        counter++;
    }
        average = total/10;
        System.out.print("avg is: "+ average);
  }
}