public int findNumberofWaysToMaze( boolean[][] maze, boolean[][] visitedMap,
                                   int currentX, int currentY, int targetX, int targetY )
{
    if( currentX == targetX && currentY == targetY ) return 1;

    if( currentX < 0 || currentX >= maze.length ) return 0;            // X out of bounds
    if( currentY < 0 || currentY >= maze[currentX].length ) return 0;  // Y out of bounds
    if( visitedMap[currentX][currentY] == true ) return 0;             // Already seen
    if( maze[currentX][currentY] == true ) return 0;                   // Wall

    visitedMap[currentX][currentY] = true;

    int numberofWays = 0;
    numberofWays += findNumberofWaysToMaze(maze, visitedMap, currentX-1, currentY, targetX, targetY );
    numberofWays += findNumberofWaysToMaze(maze, visitedMap, currentX+1, currentY, targetX, targetY );
    numberofWays += findNumberofWaysToMaze(maze, visitedMap, currentX, currentY-1, targetX, targetY );
    numberofWays += findNumberofWaysToMaze(maze, visitedMap, currentX, currentY+1, targetX, targetY );

    visitedMap[currentX][currentY] = false;
    return numberofWays;
}