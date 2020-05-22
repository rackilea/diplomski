boolean isNotNumber = true;
do
{
    try
    {
        String n = JOptionPane.showInputDialog("Enter a number");
        int number= Integer.parseInt(n);
        isNotNumber = false;
    }
    catch(NumberFormatException e)
    {
        System.out.println("Not a Number");
    }
} while (isNotNumber);
System.out.println("You entered a number");