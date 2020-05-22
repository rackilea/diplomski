public static void main(String args[]) {
Scanner scan = new Scanner(System.in);
String password;

 password = "Fish";  // assigning  value to String password

 System.out.println("enter value");

String temp=scan.nextLine(); //scanner takes nextline entered and assign it to temp

   //  if (scan.equals(password))  is wrong ,you want to compare value taken by scanner , what you have wriiten is incorrect. scan is object of Scanner.Not value taken by it


 if(temp.equals(password))  //if entered value eqauls your assigned       password value
  {
      System.out.println("You pass!"); // else print you pass
  }
else
{
  System.out.println("You're wrong!"); //else  print "you are wrong"
}