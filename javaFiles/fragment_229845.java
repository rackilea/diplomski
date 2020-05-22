Scanner scan = new Scanner(System.in);
System.out.println("\nHow many times?  ");
int times = scan.nextInt();
double sum = 0;

for(int i = 0; i < times; i++) {
    System.out.println("\nEnter the number to be squared: ");
    double d = input.nextDouble();
    double squ = d * d;
    System.out.println(squ + "\n\n");
    sum += squ;
}
System.out.println("\n\nSum = " + sum);