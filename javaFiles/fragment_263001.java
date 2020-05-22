private static final String[] DIRECTIONS = {"UP","DOWN","RIGHT","LEFT"};

public static String getDirectionPrefix(String input) {
    for (String direction : DIRECTIONS) {
        if (input.startsWith(direction)) {
            return direction;
        }
    }
    return null;
}