public static boolean isHorizontalWin(char[][] map, int player)
    {
        int count = 0;

        int r;
        int c;

        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map.length; j++)
            {
                if (map[i][j]==(player))
                {
                    r = i;
                    c = j;
                    while (r >= 0 && r <= 18 && c >= 0 && c <= 18 && map[r][c] == player)
                    {
                        count ++;
                        r += 0;
                        c += 1;
                    }
                    if (count == 5)
                    {
                        return true;
                    } else {
                        count = 0;
                    }
                }
            }
        }
        return false;
    }