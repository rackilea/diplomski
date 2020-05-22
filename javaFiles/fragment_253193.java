boolean[][] visitedBefore = new boolean[width][height];
boolean[][] isOnPerimeter = new boolean[width][height];
int[] deltaX = {-1,  0,  1, -1, 1, -1, 0, 1},
      deltaY = {-1, -1, -1,  0, 0,  1, 1, 1};
Queue<Point> searchNext = new LinkedList<>();
searchNext.add(points.get(0)); //Just need one point to get going
while(!searchNext.isEmpty()){
    Point p = searchNext.remove(); //take what's waiting at the front of the queue
    if(visitedBefore[p.getX()][p.getY()]){
        continue; //already check this spot!
    }

    //mark that we've been here
    visited[p.getX()][p.getY()] = true;

    //look at all of this Point's neighbors
    for(int i = 0 ; i < deltaX.length ; i++){
        int newX = p.getX() + deltaX[i];
        int newY = p.getY() + deltaY[i];

        //make sure this isn't out of bounds
        if(newX < 0 || newX >= width || newY<0 || newY>=height){
            isOnPerimeter[p.getX()][p.getY()] = true; //if you decide bordering the edge of the image counts as being on the perimeter
            continue;
        }

        //check if this new point we're considering isn't part of the image
        if( binaryImage[p.getX()][p.getY()] != binaryImage[newX][newY] ){
            //if it isn't, then this Point p must be on the perimeter
            isOnPerimeter[p.getX()][p.getY()] = true;
        } else {
            /* otherwise, this new point we're considering is part of the
             * same object, and could be part of the perimeter. */
            searchNext.add(new Point(newX, newY));
        }
    }
}