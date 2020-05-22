/**
 * @param args the command line arguments
 */
public static void main(String[] args)
{
    Vector <Integer> intList = new Vector <Integer> ();

    //getting the numbers from the user
    char ans = 'y';

    while(ans == 'Y' || ans == 'y')
    {
        System.out.print("Enter a Number: ");
        intList.addElement(console.nextInt());

        System.out.print("Do You Want to Continue?(Y/N)");
        ans = console.next().charAt(0);
    }

    for (int i = 1; i <= (intList.size())-1; i++)
    {
        if (intList.elementAt(i) < intList.elementAt(i-1))
        {
            int j = i - 1;
            while(j>0 && intList.elementAt(i) < intList.elementAt(j))
            {
                j--;
            }
            intList.insertElementAt(intList.elementAt(i),j);
            intList.removeElementAt(i);
        }
    }
    System.out.print(intList);
}