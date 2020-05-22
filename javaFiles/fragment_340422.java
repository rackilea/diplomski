public class WeightOnADifferentPlanet { 
static Scanner scan = new Scanner ( System.in ); 

public static void main ( String[] args ){   



System.out.println("What planet do you want to travela:?");

     String planetName = scan.nextLine(); 



 System.out.println("Please enter your weight:"); 
 int weight = Integer();


 //int weight = scan.nextInt();


 double earthCalculation = weight * 1.0; 
 double jupiterCalculation = weight * (21.0 / 8.0); //check
 double marsCalculation = weight * (3.0 / 8.0); 
 double mercuryCalculation = weight * (3.0 / 10.0); 
 double neptuneCalculation = weight * (11.0 / 10.0); //check 
 double plutoCalculation = weight * (7.0 / 10.0); 
 double saturnCalculation = weight * (6.0 / 5.0); //check
 double uranusCalculation = weight * (9.0 / 10.0); 
 double venusCalculation = weight * (7.0 / 8.0);


 if (planetName.equalsIgnoreCase("Earth")) 
 {
   System.out.println("Your weight on "+planetName+" is: "+earthCalculation+" pounds."); 
 }
 else if (planetName.equalsIgnoreCase("Jupiter"))
 {
   System.out.println("Your weight on "+planetName+" is: "+jupiterCalculation+" pounds."); 
 }
 else if (planetName.equalsIgnoreCase("Mars")) 
 {
   System.out.println("Your weight on "+planetName+" is: "+marsCalculation+" pounds."); 
 }
 else if (planetName.equalsIgnoreCase("Mercury")) 
 {
   System.out.println("Your weight on "+planetName+" is: "+mercuryCalculation+" pounds."); 
 } 
 else if (planetName.equalsIgnoreCase("Neptune")) 
 {
   System.out.println("Your weight on "+planetName+" is: "+neptuneCalculation+" pounds."); 
 }
 else if (planetName.equalsIgnoreCase("Pluto")) 
 {
    System.out.println("Your weight on "+planetName+" is: "+plutoCalculation+" pounds."); 
 }
 else if (planetName.equalsIgnoreCase("Saturn")) 
 {
   System.out.println("Your weight on "+planetName+" is: "+saturnCalculation+" pounds."); 
 }
  else if (planetName.equalsIgnoreCase("Uranus")) 
 {
   System.out.println("Your weight on "+planetName+" is: "+uranusCalculation+" pounds."); 
 } 
   else if (planetName.equalsIgnoreCase("Venus")) 
 {
   System.out.println("Your weight on "+planetName+" is: "+venusCalculation+" pounds."); 

 }
   else {
       System.out.println("Planet not recognized");
   }
 }



 public static int Integer(){
      while (true)
      {
       try
       {
        return scan.nextInt();
       }
       catch (InputMismatchException e)
       {
           scan.next();
           System.out.print("That’s not an integer. Try again: ");
       }

}
}
}