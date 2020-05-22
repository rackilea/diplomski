public enum Label implements org.neo4j.graphdb.Label {
  CAR("Car"),
  BIKE("Bike"),
  BUS("Bus");

  private String name;

  private Label(name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}