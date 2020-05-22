Scanner reader= new Scanner(System.in);
while (true)
{    
     equation = reader.nextLine();  
     //YOU ALSO need a reason to break out of this loop.
     //LIKE IF equation == "EXIT" or "0"
         //BREAK
     result=Calculator.evaluateEquation(equation);
}   
System.out.println();
System.out.println("That expression equals " + result);
System.out.println();