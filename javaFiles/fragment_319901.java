Scanner number = new Scanner(System.in);  // Reading from System.in
System.out.println("Enter a two digit number (10-99) ");
int n = 0;
 if(number.hasNextInt()) {
     n = number.nextInt();
 } else {
    number.next();  //Clear bad input
    System.out.println("Invalid");
}

int m = 0;


if ( n< 10 || n > 99) {           
   System.out.println("this isnt a valid input and you have killed my program ;(");
}


System.out.println("Enter another two digit number (10-99) ");
if(number.hasNextInt()) {
     m = number.nextInt();
} else {
    number.next();
    System.out.println("Invalid");
}

if (n< 10 || n > 99) {           
    System.out.println("this isnt a valid input and you have killed my program ;(");
}        
int sum = n + m;
System.out.println(sum);