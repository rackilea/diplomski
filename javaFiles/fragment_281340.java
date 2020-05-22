public static void main(String[] args) {

    Scanner keyboard = new Scanner (System.in);
    double budget;


    System.out.print("Enter your budget for the month: "); 
    budget = keyboard.nextDouble();           
    System.out.println("Type -99 to stop calculations"); 
    System.out.println(); 
    byte start = 1; 

    double expense = 0;  

    while (expense != -99) {

        System.out.print("Enter expense " + start + " :"); 
        expense = keyboard.nextDouble(); 
        if (expense == -99) {
            System.out.println(); 
            System.out.printf("Your current total budget is: $%,.2f \n" , budget); 
        }else{
            budget = (budget - expense);
        }
        start++;             
    }
}