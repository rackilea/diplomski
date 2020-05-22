class Coordinates {

  private int x;
  private int y;

  public Coordinates(int x, int y) {
     ...
  }

  // getters

  // equals and hashcode using x and y
}

Map<Coordinates, Location> locations = new HashMap<Coordinates, Location>();