int a, b, c;

Scanner scan = new Scanner(System.in);
System.out.println("Inserire a");
a = scan.nextInt();
System.out.println("Inserire b");
b = scan.nextInt();
System.out.println("Inserire c");
c = scan.nextInt();

if (a == b && a == c){
     System.out.println("All the same");
}

else if (((a==b) && b!=c) || ((a==c) && (b!=c)) || ((b == c) && (a!= c)));
{
    System.out.println("Two the same and one different ");
}
else 
{
    System.out.println("Tutti diversi");
    System.out.print(" All different");
}