count = 1.03 * annualsales + 5000;
for (int i = 0; i < 10; i++)
{
   count = 1.03 * count + 5000;
   System.out.println("Your total is: " + count);
}