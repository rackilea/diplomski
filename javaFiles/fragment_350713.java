Scanner s=new Scanner(System.in);
String toContinue="y";
while( (your code) && "y".equalsIgnoreCase(toContinue))
{
      //your code
      System.out.println("Do you want to continue : (Y-to continue,any otherto stop )");
      toContinue=s.next();
}