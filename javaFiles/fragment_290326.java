import java.util.Scanner;

public static void main(String[] args){

Scanner scan = new Scanner(System.in);

double len = 0;
double wid = 0; 

System.out.print("Enter the length in feet:(##.##) ");

   len = scan.nextDouble();

System.out.print("\nEnter the width in feet: (##.##) ");

   wid = scan.nextDouble();

System.out.print("\n"+"The area is "+wid*len+" square feet.");

}