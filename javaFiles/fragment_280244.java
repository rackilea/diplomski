public boolean hasCollided(int xa,int ya) {
        int xMin = 0;
        int xMax = 7;
        int yMin = 3;
        int yMax = 7;

        for (int x = xMin; x < xMax; x++)   {
            if (isSolidTile(xa,ya,x,yMin))  {
                return true;
            }
        }
        for (int x = xMin; x < xMax; x++)   {
            if (isSolidTile(xa,ya,x,yMax))  {
                return true;
            }
        }
        for (int y = yMin; y < xMax; y++)   {
            if (isSolidTile(xa,ya,xMin,y))  {
                return true;
            }
        }
        for (int y = yMin; y < xMax; y++)   {
            if (isSolidTile(xa,ya,xMax,y))  {
                return true;
            }
        }
        return false;
    }