do
{
    int x = rnd.nextInt(rows);
    int y = rnd.nextInt(cols);
    if (map[x][y] != 'B')
    {
        map[x][y] = 'B';
        count++;
    }
} while(count < 10);