int m1 [][] = new int[3][3];
int m2 [][] = new int[3][3];
System.out.print("Enter List1 and List2 (18 numbers): ");
for (int row = 0; row < m1.length; row++)
{
    for(int column = 0; column < m1[row].length; column++)
    {
        m1[row][column] = input.nextInt();
    }
}
for (int row = 0; row < m2.length; row++)
{
    for(int column = 0; column < m2[row].length; column++)
    {
        m2[row][column] = input.nextInt();
    }
}

//Print two array
System.out.print("List1: ");
for (int row = 0; row < m1.length; row++)
{
    for(int column = 0; column < m1[row].length; column++)
    {
        System.out.print(m1[row][column] + " ");
    }
    System.out.println();
}
//Print two array
System.out.print("List2: ");

for (int row = 0; row < m2.length; row++)
{
    for(int column = 0; column < m2[row].length; column++)
    {
        System.out.print(m2[row][column] + " ");
    }
    System.out.println();
}