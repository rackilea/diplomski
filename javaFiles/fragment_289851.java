public class Label implements org.neo4j.graphdb.Label {
  public static final Label CAR = new Label("Car");
  public static final Label BIKE = new Label("Bike");
  public static final Label BUS = new Label("Bus");

  private String name;

  private Label(String name) {
    this.name = name;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }
}