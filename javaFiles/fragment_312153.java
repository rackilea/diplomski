import java.util.*; /*edited this line*/
class dispay
{
public static void main(String[]args)
{
  Scanner stdIn=new Scanner(System.in);
  System.out.print("Please enter the ammount or '-1' to exit:");
  String input=stdIn.nextLine(); 
  int inputInt=0;  
  Vector v=new Vector(1,1); /*defines an empty vector of ints*/
    while(!(input.equals("-1")))
    {
      inputInt=Integer.parseInt(input);
      v.addElement(new Integer(inputInt));  /*adds the new integer to the vector of ints*/         
      System.out.print("Please enter the ammount or '-1' to exit:");
      input=stdIn.nextLine();
    }
  System.out.println("Original price: "+v.toString()); /*prints the full vector in string representation*/
  }
}