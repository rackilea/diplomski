public static void main(String[] args)
{
    int largest = 0;
    for(int i = 1; i <= 10; i++)
    {
        boolean valid = false;      
        while (!valid)
        {
            String numStr = JOptionPane.showInputDialog("Please enter number " + i + ":");
            int number = Integer.parseInt(numStr);  //Converts string value to integer

            if (number >= 0 && number <= 9)
            {
                valid = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "INVALID INPUT...Try Again!!!", "Results", JOptionPane.YES_OPTION);
            }           
        }

        if (number > largest)
        {
            largest = number;
        }
    }   
    JOptionPane.showMessageDialog(null, "The Largest Number Is: " + largest, "Results", JOptionPane.PLAIN_MESSAGE);
}