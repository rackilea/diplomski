int[] deltaX = {-1,  0,  1, -1, 1, -1, 0, 1},
      deltaY = {-1, -1, -1,  0, 0,  1, 1, 1};
outer: for(Point p : points){
    inner: for(int i = 0 ; i < deltaX.length ; i++){
        int newX = p.getX() + deltaX[i];
        int newY = p.getY() + deltaY[i];
        //check if this new point we're considering is outside the image
        if(newX < 0 || newX >= width || newY<0 || newY>=height){
            perimeter.add(p); //if you decide bordering the edge of the image counts as being on the perimeter
            continue outer;
        }

        //check if this new point we're considering isn't part of the image
        if( binaryImage[p.getX()][p.getY()] != binaryImage[newX][newY] ){
            //if it isn't, then this Point p must be on the perimeter
            perimeter.add(p);
            continue outer;
        }
    }
}