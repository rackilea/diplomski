// A class in the default package

// Import java.math
import java.math.*;

// Class Name: StackTest
public class StackTest {

// Your main method: The entry point of your program
 public static void main (String[] args){

 // Creates an object Stack2 and references it to stk
 Stack2 stk = new Stack2("Stack");
 // Runs a for loop 10 times and pushes an element into the stack and prints the result into the console
       for(int i = 0; i < 10; i++){
         stk.push("Item: " + (i + 1));

         System.out.println("Pushing: Item: " + (i + 1));
 }
 // Prints your stack
 System.out.println("\n" + stk.print());

 // Runs a loop 10 times and pops each item of the stack out
 for(int i = 0; i < 10; i++){
    System.out.println("Popping: " + stk.pop());
 }
 // Prints your stack
 System.out.println("\n" + stk.print());
 }
}