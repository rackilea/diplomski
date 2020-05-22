//user selects operation
System.out.println("Enter First Number."); 
int a = in.nextInt(); 
System.out.println("Enter Second Number."); 
int b = in.nextInt(); 

int endValue;
if (choice == 1) //Addition
    endValue = c1.addition(a, b); 
else if (choice == 2)
    endValue = c1.subtraction(a, b); 
else
    //throw exception since there was no endValue calculated

System.out.println("The result is: " + endValue + ".");