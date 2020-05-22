public static int input()//Takes the user's input
{
   Scanner in=new Scanner(System.in);
   System.out.println("Please input a number");
   argument=in.nextInt();
   number=Integer.toString(argument);
   x=number.substring(0);
   return Input();  // ***** recursion here *****
}