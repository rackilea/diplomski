import java.util.Scanner;

// ...
int counter = 0;

System.out.println("How many characters?");
Scanner keyboard = new Scanner(System.in);
counter = keyboard.nextInt();

char[] sortValues = new char[counter+1];

// Start your index variable off at 0
for (int x = 0; x < counter; x++) { 
  System.out.println("Enter character "+(x)+":");
  keyboard = new Scanner(System.in);
  String line = keyboard.nextLine();
  sortValues[x] = line.charAt(0);
}