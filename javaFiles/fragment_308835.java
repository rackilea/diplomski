List<Integer> myCoordinates; 

// initalize myCoordinates so it has  
// edges.size()*points_per_edge*coordinates_per_point elements
// = edges.size() * 2 * 2 in your case

for (int i = 0; i < edges.size(); i++) {
   int j = i*4;
   Edge edge = edges.get(i);
   edge.p1.x = myCoordinates.get(j);
   edge.p1.y = myCoordinates.get(j+1);
   edge.p2.x = myCoordinates.get(j+2);
   edge.p2.y = myCoordinates.get(j+3);
}