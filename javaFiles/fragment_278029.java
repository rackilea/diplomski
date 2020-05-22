public static void main(String[] args)
{
  Scanner stdin = new Scanner(System.in);  // define a local variable ...
  foo(stdin);                              // ... and pass it to the method
}

private static void foo(Scanner stdin)
{
  String s = stdin.next();                 // use the method parameter
}