Map<String, Set<Point>> mapSets = new HashMap<String, Set<Point>>();
    Set<Point> p1 = new HashSet<Point>();
    p1.add(new Point(2, 3));
    p1.add(new Point(2, 4));
    p1.add(new Point(2, 5));
    p1.add(new Point(3, 1));
    p1.add(new Point(4, 1));
    p1.add(new Point(5, 1));

    mapSets.put("p1", p1);

    Map<Double, List<Point>> horMap = new HashMap<Double, List<Point>>();
    Map<Double, List<Point>> verMap = new HashMap<Double, List<Point>>();

    for ( Point p : p1 )
    {
      List<Point> presList = horMap.get(p.getX());
      if ( presList == null )
      {
        presList = new ArrayList<Point>();
        presList.add(p);
      }
      else
      {
        presList.add(p);
      }
      horMap.put(p.getX(), presList);
    }

    for ( Point p : p1 )
    {
      List<Point> presList = verMap.get(p.getY());
      if ( presList == null )
      {
        presList = new ArrayList<Point>();
        presList.add(p);
      }
      else
      {
        presList.add(p);
      }
      verMap.put(p.getY(), presList);
    }

    // boolean hNe = checkHorNeighbor(horMap);
    // boolean vNe = checkVerNeighbor(verMap);

    for ( Entry<Double, List<Point>> point : horMap.entrySet() )
    {
      if ( point.getValue().size() >= 3 )
      {
        Collections.sort(point.getValue(), new Comparator<Point>()
        {
          @Override
          public int compare(Point o1, Point o2)
          {
            return Double.valueOf(o1.getY()).compareTo(Double.valueOf(o2.getY()));
          }
        });

        int count = 0;
        for ( int i = 0; i < point.getValue().size(); i++ )
        {
          if ( point.getValue().get(i).getY() + 1 == point.getValue().get(i +
                                                                          1).getY() )
          {
            count++;
          }
          if ( count >= 2 )
          {
            System.out.println("Found horizontal pair");
            count = 0;
            break;
          }
        }

      }
    }
  }