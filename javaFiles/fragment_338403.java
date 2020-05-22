public class AutomobileDescription{ 
/**
Constructor to display the make, model and price the new automobile I wish to purchase
*/

public AutomobileDescription(String carMake, String carModel, String carPrice) 
{
    m = make;
    mo = model;
    p = carPrice;
} 
 private String m;
 private String mo;
 private String p;

 public String getAutomobileinfo()
 {  
    return m + mo +  p;
 }
 public static void main(String[] args){
    AutomobileDescription myAutomobile = new AutomobileDescription("Toyota", "Camry", "22055");
    System.out.println("The Make, Model and Price of the car is: " + myAutomobile.getAutomobileinfo()); 
 }
}