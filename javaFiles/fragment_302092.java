int i = 0;

while (i < 1 || i > 2)
{
    try
    {
        System.out.println("Please indicate if customer is wholesale or retail.  Type 1 for wholesale or 2 for retail");
        i = scan.nextInt();
    } 
    catch (InputMismatchException e) 
    {
        System.out.println("You did not input a valid value.  Please enter an Integer value between 1 and 2");
        scan.next();
    }
}
...