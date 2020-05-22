for (int x = 0; x < map.length; x++)
{
    for (int y = 0; y < map[x].length; y++)
    {
        if (map[x][y] == 'B')
            continue;

        // Count the number of mines around map[x][y]
        int mines = 0;
        for (int xOffset = -1; xOffset <= 1; xOffset++)
        {
            // This is an important step - without it, we will access elements off the edge of the map
            if (x + xOffset < 0 || x + xOffset >= map.length)
                continue;

            for (int yOffset = -1; yOffset <= 1; yOffset++)
            {
                // Another check for the edge of the map
                if (y + yOffset < 0 || y + yOffset >= map[x].length)
                    continue;

                if (map[x + xOffset][y + yOffset] == 'B')
                    mines++;
            }
        }

        map[x][y] = "012345678".charAt(mines); // Get the number as a character
    }
}