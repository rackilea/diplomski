public static List<Area> getAreas(Area area) {
    PathIterator iter = area.getPathIterator(null);
    List<Area> areas = new ArrayList<Area>();
    Path2D.Float poly = new Path2D.Float();
    Point2D.Float start = null;
    while(!iter.isDone()) {
      float point[] = new float[2]; //x,y
      int type = iter.currentSegment(point); 
      if(type == PathIterator.SEG_MOVETO) {
           poly.moveTo(point[0], point[1]);
      } else if(type == PathIterator.SEG_CLOSE) {
           areas.add(new Area(poly));
           poly.reset();
      } else {
        poly.lineTo(point[0],point[1]);
      } 
      iter.next();
    }
    return areas;
   }

   public static void main(String[] args) {
    Area a = new Area(new Polygon(new int[]{0,1,2}, new int[]{2,0,2}, 3));
    Area b = new Area(new Polygon(new int[]{0,2,4}, new int[]{0,2,0}, 3));
    b.subtract(a);

    for(Area ar : getAreas(b)) {
     PathIterator it = ar.getPathIterator(null);
     System.out.println("New Area");
     while(!it.isDone()) {
      float vals[] = new float[2];
      int type = it.currentSegment(vals);
      System.out.print(" " + "[" + vals[0] + "," + vals[1] +"]");
      it.next();
     }
     System.out.println();
    }
   }