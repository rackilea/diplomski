public class AddingMachine {   // Save as 'AddingMachine.java"
   public static void main(String[] args) { 
        System.out.println();
        System.out.println("Welcome to the Adding Machine.");
        System.out.println();

        System.out.println("What is the first number?");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        System.out.println("What is the second number?");
        int num2 = sc.nextInt();
        System.out.println();

        int sum = num1 + num2;
        System.out.print(sum);
        System.out.print(", the sum is: ");
        System.out.print(sum);
  }
}