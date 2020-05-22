for(int x = 0; x < heightmap.width(); ++x)
    for(int y = 0; y < heightmap.height(); ++y)
        if(find_pattern(x, y))
            // YAY! pattern starts at (x, y)

// start at (x, y) and find an exact match
boolean find_pattern(int x, int y)
{
      for(int xx = 0; xx < pattern.width(); ++x)
          for(int yy = 0; yy < pattern.width(); ++x)
              if(heightmap[x + xx][y + yy] != pattern[xx][yy])
                  return false;
      return true; 
}