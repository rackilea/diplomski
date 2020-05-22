{
        for(int r = 0; r < height; r++)
            for(int c = 0; c < width; c++)
            {
                if(space[r][c] == '.')
                    return true;
            }
        return false;
   }