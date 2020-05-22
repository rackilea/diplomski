int[][] values = new int[rows][];
for(int i = 0; i < values.length; i++)
{
    values[i] = new int[i+1];

    for(int j = 0; j < values[i].length; j++)
    {
        values[i][j] = kb.nextInt();
    }
}