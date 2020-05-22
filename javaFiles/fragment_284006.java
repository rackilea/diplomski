public static void main(String args[])
{

    int count=1;
    for(int i=1;i<=5;i++)
    {
        if (i%2 == 0)
        {
            count += i-1; // there are i numbers on this row, highest is (i-1) larger than lowest
            for(int j=1;j<=i;j++)
            {
                if(i>j) {
                    System.out.print(count + "*");
                    count--;
                }else {
                    System.out.print(count);
                }
            }System.out.println();
            count += i // count was lowest number on current row. Increase it to lowest number on next row.
        }
        else 
        {
            for(int j=1;j<=i;j++)
            {
                if(i>j) {
                    System.out.print(count + "*");
                    count++;
                }else {
                    System.out.print(count);count++;
                }
            }System.out.println();
        }
    }
}