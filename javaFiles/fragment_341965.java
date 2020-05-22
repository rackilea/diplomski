Segment findClosestSegment(ArrayList<Segment> segments, Point target) {
  double dist, minDist = Double.MAX_VALUE;
  Segment minDistSegment;
  for(Segment s: segments) {
    dist = s.distanceTo(target);
    if(dist < minDist) {
      minDist = dist;
      minDistSegment = s;
    }
  }
  return minDistSegment;
}