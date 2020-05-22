EnumMap<Direction, MapLocation[]> map = new EnumMap(Direction.class);
map.put(Direction.NORTH, new MapLocation[] {  new MapLocation(0, 1), 
                                              new MapLocation(0, 2),
                                              new MapLocation(0, 3) });
map.put(Direction.NORTH, new MapLocation[] {  new MapLocation(0, -1), 
                                              new MapLocation(0, -2),
                                              new MapLocation(0, -3) });