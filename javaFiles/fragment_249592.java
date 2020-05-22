array[x][y] = n;
        if ( fill(x+1, y-2, n+1) || fill(x-2, y+1, n+1) || fill(x+1, y+2, n+1)
           || fill(x+2, y+1, n+1) || fill(x-2, y-1, n+1) || fill(x-1, y-2, n+1) || 
           fill(x-1, y+2, n+1) || fill(x+2, y-1, n+1)) 
            return true;
        else
        {
            array[x][y] = 0; // <- add this line
            return false; 
        }