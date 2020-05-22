private static boolean checkVerNeighbor(Map<Double, List<Point>> verMap)
  {

    for ( List<Point> ps : verMap.values() )
    {
      NavigableSet<Point> sortedSet = new TreeSet<Point>(new Comparator<Point>()
      {
        @Override
        public int compare(Point o1, Point o2)
        {
          return Double.valueOf(o1.getX()).compareTo(Double.valueOf(o2.getX()));
        }
      });

      sortedSet.addAll(ps);

      for ( Point p : sortedSet )
      {
        Set<Point> triplets = sortedSet.subSet(p, true,
                                               new Point(Double.valueOf(p.getX() + 2).intValue(), Double.valueOf(p.getY())
                                                                                                        .intValue()), true);
        if ( triplets.size() >= 3 )
        {
          System.out.println("Found Triplets + " + p);
          return true;

        }
      }
    }
    return false;
  }