public static void main(String[] args){
System.out.println("Welcome back!");    
Scanner scanner = new Scanner(System.in); 
System.out.println("Username: "); String   
username = scanner.next();  
System.out.println("Password: "); 
String password = scanner.next(); 
int affCount = 0; 
String aff = "";
while (affCount <= 4) { 
    System.out.println("enter new affiliate");     
     aff = scanner.nextLine(); 
    System.out.println("Alright, " + aff + " is now your new affiliate!"); 
     affCount = affCount + 1; 
     System.out.println("You now have " + affCount + " affiliates"); 
     if (affCount == 4) 
        { 
         System.out.println("Congratulations! You've accumulated 4 affiliates!" + " any new affiliates added to this branch will be extra earnings" + " You can also make a new branch and start over" + " To quit this branch, Type 'quit'");
        continue; 
        }
    } 

    while (affCount > 4) { 
         if (aff.equals("quit") == false) 
             { 
              System.out.println("enter new affiliate"); 
              aff = scanner.nextLine(); 
              System.out.println("Alright, " + aff + " is now your new affiliate!"); 
              affCount = affCount + 1; 
              System.out.println("You now have " + affCount + " affiliates"); 
               } 
           else if (aff.equals("quit")) 
                   { 
                   System.out.println("This branch is now over");
                   break; }
           } 
   }