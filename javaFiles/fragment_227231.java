int roomSize(int row, int col)
|   bool [x][y] v; //Array to stored visited values x is the width of the maze y is the height
|     set all bools in v to false
|    return doRoomSize(row,col, v) 
end

int doRoomSize(int r, int c, v)
|    if( v[r][c] = true ||  layout [r][c]='X' )
|     | return 0
|    end-if
|    //Now we know that its a good value
|    
|This is a maze type problem so what you need to do is


int roomSize(int row, int col)
|   bool [x][y] v; //Array to stored visited values x is the width of the maze y is the height
|     set all bools in v to false
|    return doRoomSize(row,col, v) 
end

int doRoomSize(int r, int c, v)
|    if( v[r][c] = true ||  layout [r][c]='X' )
|     | return 0
|    end-if
|    //Now we know that its a good value
|    v[r][c] = true; // we have seen this point so we addit to visted
|      int n=1;
|    //Check left
|         n+= doRoomSize(r-1, c)
|    //Check right
|        n+=doRoomSize(r+1,c)
|   //Check up 
|        n+=doRoomSize(r,c-1)
|  // Check down
|        n+=doRoomSize(r,c+1)
|     return n;
end-method