public void find() {
     List<Point> foundPoints = new ArrayList<Point>();
     for(int i = 0; i < Board.height; ++i) { //Assumes you have stored your height
       for(int j = 0; j < Board.width; ++j) { //and your width
         if(isEmpty(i, j) && hasNonEmptyNeighbor(new int[]{i,j})) {
            //Found one.  
            foundPoints.add(new Point(i, j));
         }
       }
     }
     //If you need to return a RANDOM empty field with non-empty neighbor
     //you could randomize over length of foundPoints here and select from that list.
   }