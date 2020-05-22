List<Move> moves = board.getMoves();
  HashMap<History, History> fillTable = new HashMap<History, History>();
  for (Move m : moves) {
     History h = fillTable.get(m);
     if (h == null) {
        h = new History(m);
        fillTable.put(h, h);
     } else {
        h.increment();
     }
  }
  TreeSet<History> sorted = new TreeSet<History>(fillTable.values());
  .... ready to use