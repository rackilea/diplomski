String toppingsString = keyboard.nextLine().trim();
int toppings = 0;
try
{
     toppings = Integer.parseInt(toppingsString);
}
catch(NumberFormatException nfe)
{
    toppings = 0;
}