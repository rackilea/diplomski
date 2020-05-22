for(int row = 0; row < datArray.length; row++)
{
    System.out.print("Row " + row + ": ");
    for (int column = 0; column < datArray[row].length; column++)
        System.out.print(datArray[row][column] + " ");
    System.out.print("Row Average value: " + avg[row]);
    System.out.println( );
}