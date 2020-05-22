int i = 0;
Scanner scnr = new Scanner(System.in);
System.out.print("Please enter a number: ");
i = scnr.nextInt();
while (i >= 1)
{
    System.out.println(Math.sqrt(i));
    i--;
}