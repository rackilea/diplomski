class Transfer extends Connection {
    List<Line> linesTransfer = new ArrayList();
    boolean isTransfer = true;
    public Transfer(Station s1, Station s2, int distance, Line l1, Line l2) {
      super(s1, s2, distance);
      /* Code in here */
    }
    public Transfer(Station s1, Station s2, Line l1, Line l2) {
      super(s1, s2);
      /* Code in here */
    }
  }