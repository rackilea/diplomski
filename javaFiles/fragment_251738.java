public enum Direction {
    NORTH(true), NORTH_EAST(false), EAST(true), SOUTH_EAST(false), SOUTH(true), SOUTH_WEST(false), WEST(true), NOTH_WEST(false);

    private final boolean isCardinal;

    private Direction(boolean isCardinal){
        this.isCardinal = isCardinal;
    }

    public boolean isCardinal(){
        return isCardinal;
    }

    public static Collection<Direction> getCardinalDirections(){
        return Arrays.asList(Direction.values()).stream().filter(Direction::isCardinal).collect(Collectors.toList());
    }

    public static Collection<Direction> getIncardinalDirections(){
        return Arrays.asList(Direction.values()).stream().filter(x -> !x.isCardinal()).collect(Collectors.toList());
    }
}