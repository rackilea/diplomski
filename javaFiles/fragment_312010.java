public enum Direction {

NORTH(Color.RED), WEST(Color.BLUE), EAST(Color.BLACK), SOUTH(
        Color.GREEN);

Direction(int c) {
    color = c;
}
private int color;


public int get() {
    return color;
} 
}