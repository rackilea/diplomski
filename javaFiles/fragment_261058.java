System.out.println("enter a number");  
int a=sc.nextInt(); 

while(!validateValue(a)){                   //so long value is invalid, repeat.
    System.out.println("enter a number");  
    a=sc.nextInt();                         //prompt for input
}
System.out.println("valid value");