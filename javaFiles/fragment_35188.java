public class NumberReverse {

 public int reverseNumber(int number){


int reverse = 0;
while(number !=0){
    reverse = (reverse*10)+(number%10);
    number = number/10;
}
return reverse;
}
public static void main(String a[]){
    System.out.print("Enter a number: ");   
    Scanner keyboard = new Scanner(System.in); 
        String input = keyboard.nextLine();
        try {
            NumberReverse nr = new NumberReverse();
            System.out.println("Result: " +nr.reverseNumber(Integer.valueOf(input)));

        } catch (NumberFormatException nme) {
             System.err.println("You entered not numeric value...!");
        }


  }
 }