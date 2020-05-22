// Vertical Walls 
  for(int y = (int) roomCornerDownLeft.y; y <= roomCornerDownLeft.y + roomHeigth; y++){

      dungeon[y][ (int) roomCornerDownLeft.x ] = 2;

      dungeon[y][ (int) roomCornerDownLeft.x + roomWidth ] = 2;

  } 

  // Horizontal Walls
  for(int x = (int) roomCornerDownLeft.x; x <= roomCornerDownLeft.x + roomWidth; x++){

      dungeon[ (int) roomCornerDownLeft.y ][ x ] = 2;

      dungeon[ (int) roomCornerDownLeft.y + roomHeigth][ x ] = 2;

  }