import java.util.Scanner;
class whileloop{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
    System.out.println("This is a basic calculator.");
    System.out.println("To exit, input exit when asked to input the method.");
    System.out.println("----------------------------------------------");
    while (true){
        System.out.println("to add, input '+', to subtract, input '-', to divide, input '/', to multiply, input '*' and to exit, input 'exit.'");
        System.out.println("----------------------------------------------------");
        System.out.print("Please enter a method here:");
        String method = scan.nextLine();
        if (method.equals("exit")){
            System.out.println("You chose to exit.");
            break;
        }
        else if (method.equals("+")){
            System.out.println("You chose to add.");
            System.out.print("Please enter first number here:");
            double fnum = scan.nextInt();
        scan.nextLine();
            System.out.print("Please enter second number here:");
            double snum = scan.nextInt();
        scan.nextLine();
            double ans = fnum + snum;
            System.out.print("The answer is");
            System.out.println(ans);
        }
        else if(method.equals("-")){
            System.out.println("You chose to subtract.");
            System.out.print("Please enter first number here:");
            double fnum = scan.nextInt();
        scan.nextLine();
            System.out.print("Please enter second number here:");
            double snum = scan.nextInt();
        scan.nextLine();
            double ans = fnum - snum;
            System.out.print("The answer is");
            System.out.println(ans);
        }
        else if(method.equals("*")){
            System.out.println("You chose to multiply.");
            System.out.print("Please enter first number here:");
            double fnum = scan.nextInt();
        scan.nextLine();
            System.out.print("Please enter second number here:");
            double snum = scan.nextInt();
        scan.nextLine();
            double ans = fnum * snum;
            System.out.print("The answer is");
            System.out.println(ans);
        }
        else if(method.equals("/")){
            System.out.println("You chose to divide.");
            System.out.print("Please enter first number here:");
            double fnum = scan.nextInt();
        scan.nextLine();
            System.out.print("Please enter second number here:");
            double snum = scan.nextInt();
        scan.nextLine();
            double ans = fnum / snum;
            System.out.print("The answer is");
            System.out.println(ans);
        }
        else{
            System.out.println("Invalid input. please select a valid input from the list of operators given.");
        }
    }
}
}