import java.util.Scanner;
public class Demo3
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter how many friends: ");
        int numOfFriends = Integer.parseInt(scan.nextLine());
        String arrayOfNames[] = new String[numOfFriends];
        long income[] = new long[numOfFriends];
        for (int i = 0; i < arrayOfNames.length; i++)
        {
            System.out.print("\nEnter the name of friend " + (i+1) + " : ");
            arrayOfNames[i] = scan.nextLine();
        }
        for(int j = 0; j<arrayOfNames.length;j++)
        {
            System.out.print("\nEnter the income of friend " + (j+1) + " : ");
            income[j] = scan.nextLong();
        }
        scan.close();
    }
}