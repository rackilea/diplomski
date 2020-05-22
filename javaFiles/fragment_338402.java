public class AutomobileDescription
{ 
    /**
    Constructor to display the make, model and price the new automobile I wish to purchase
   */

public AutomobileDescription(String carMake, String carModel, /*no return type*/ carPrice) 
{
    make = m; 
    model = mo;
    price = p; 
} 
 public String m =("Toyota");
 public String mo =("Camry");
 public String p =("22055");

    public String getAutomobileinfo()
    {  
     return m + mo +  p; /*return? then why statements after this?*/
     Automobile myAutomobile = new Automobile(Toyota, Camry, 22055);
     System.out.println("The Make, Model and Price of the car is: m + mo + p "); 

    }
}