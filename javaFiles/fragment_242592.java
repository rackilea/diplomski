void permutate( List<Point> points, int pointIndex, int[] values ) {
   Point p = points.get(pointIndex);
   for( int x = p.x; x < p.y; x++ ) {
     values[pointIndex] = x;

     //this assumes pointIndex to be between 0 and points.size() - 1
     if( pointIndex < points.size() - 1 ) {          
       permutate( points, pointIndex + 1; values );
     }
     else { //pointIndex is assumed to be equal to points.size() - 1 here
       //you have collected all intermediate values so solve the equation
       //this is simplified since you'd probably want to collect all values where the result is correct
       //as well as pass the equation somehow
       int result = solveEquation( values );
     }
   }
 }

 //initial call
 List<Point> points = ...;
 int[] values = new int[points.size()];
 permutate( points, 0, values );