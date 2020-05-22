Optional<? extends Connection<?>> conn = ((GraphRoadModel)getRoadModel()).getConnection(this);
Point from;
double dist = 0;
if( conn.isPresent() ){
  dist += Point.distance(getRoadModel().getPosition(this),conn.to());
  from = conn.to();
} else {
  from = getRoadModel().getPosition(this);
}

List<Point> path = getRoadModel().getShortestPathTo(from, point);
Measure<Double,Length> distance = getRoadModel().getDistanceOfPath(path); 

// total distance is the sum of distance and dist