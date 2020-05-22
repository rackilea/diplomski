public enum Direction {
  NORTH("north", "n"),
  NORTHWEST("northwest", "nw"),
  ...
  IN("in"),
  OUT("out");

  private final static Map<String, Direction> INSTANCES;

  static {
    Map<String, Direction> map = new HashMap<String, Direction>();
    for (Direction direction : values()) {
      for (String exit : direction.exits) {
        if (map.containsKey(exit)) {
          throw new IllegalStateException("Exit '" + exit + "' duplicated");
        }
        map.put(exit, direction);
      }
    }
    INSTANCES = Collections.unmodifiableMap(map);
  }

  private final List<String> exits;

  Direction(String... exits) {
    this.exits = Collections.unmodifiableList(Arrays.asList(exits));
  }

  public List<String> getExits() { return exits; }
  public String getName() { return exits.get(0); }
  public static Map<String, Direction> getInstances() { return INSTANCES; }
  public static Direction getDirection(String exit) { return INSTANCES.get(exit); }
}