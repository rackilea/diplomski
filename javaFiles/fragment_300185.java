class SparseMatrix<X> {
  private Map<Coord, X> values = new HashMap<Coord, X>();

  public SparseMatrix() {
  }

  public X get(int x, int y) {
     return values.put(new Coord(x,y)); // null if there's no value
  }

  public void set(int x, int y, X value) { // you can use null (like in a List)
     values.set(new Coord(x,y), value);
  }

  private static class Coord {
    int x; int y;
    public Coord(int x, int y) {
       this.x = x;
       this.y = y;
    }

    @Override
    public boolean equals(Object other) {
       if (other instance of Coord) {
          Coord o = (Coord) other;
          return o.x == x && o.y == y;
       }
       return false;
    }

    @Override
    public int hashCode() {
       return o.x + o.y; // or some more clever implementation :)
    }

  }
}