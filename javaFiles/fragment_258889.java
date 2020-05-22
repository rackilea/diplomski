public class Hypot{
   public static void main(String args[])
  { 
   double hypotenuse;
   double d1 = 0.0d;
   double d2 = 0.0d;

   if(args.length!=2)
   {
   System.out.println("You need to enter two arguments!");
   System.exit(1);
   }

   try
   {
   d1= Double.parseDouble(args[0]);
   d2= Double.parseDouble(args[1]);
   }
   catch(NumberFormatException nfe)
   {
   System.out.println("Arguments need to be numbers!");
   System.exit(2);
   } 




   hypotenuse=Math.sqrt((d1*d1)+(d2*d2));
   System.out.print("The hypotenuse of the right angle triangle with sides of "+d1+"and"+d2+"is"+hypotenuse);
  }
 }