System.out.println("This programme makes some calculations");
Scanner scan = new Scanner(System.in);
System.out.println("Enter the first number ");
a = scan.nextDouble();
System.out.println("Enter the second number ");
b = scan.nextDouble();

// --- New code ------------

// Since the operations are in a different class you need to 
// create an instance of that class
Operations ops = new Operations();

sum = ops.sum( a, b );
difference = ops.difference( a, b );
product = ops.product( a, b );
quotient = ops.quotient( a, b );

// end new code --------------

System.out.println("The sum: "+sum);
System.out.println("The difference: "+difference);
System.out.println("The product: "+product);
System.out.println("The quotient: "+quotient);