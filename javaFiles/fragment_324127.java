public class Practical4
{

    public static void main(String[] args)
    {
        if(args.length==0)
        {
        System.out.println("No arguments are passed");
        }
        else
        {

        int a=Integer.parseInt(args[0]);
        char p=args[1].charAt(0);
        int b=Integer.parseInt(args[2]);

        switch(p)
        {
            case '+':
                System.out.println("Addition of "+a+" and "+b+" : "+(a+b));
                break;

            case '-':
                System.out.println("Subtraction of "+a+" and "+b+" : "+(a-b));
                break;

            case '*':
                System.out.println("Multiplication of "+a+" and "+b+" : "+(a*b));
                break;

            case '/':
                System.out.println("Division of "+a+" and "+b+" : "+(a/b));
                break;

            case '%':
                System.out.println("Modulo of "+a+" and "+b+" : "+(a%b));
                break;


            default:
                System.out.println("Please Enter '+', '-', '*', '/' & '%' operator only.");
        }
        }

    }

}