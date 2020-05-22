class Segment {
  Point p1, p2;
  public Segment(Point a, Point b) { p1=a; p2=b; }
}

ArrayList<Segment> segments = new ArrayList<Segment>();
for(int i=0, last=points.size()-1; i<last; i++) {
  segments.add(new Segment(points.get(i), points.get(i+1));
}