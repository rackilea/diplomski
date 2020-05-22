public static void main(String[] args) {
    String input = "1111111111111111111111111111111111111111111\n" +
                   "1000000010001000001000000010000000100000001\n" +
                   "1010111010101010101111101011111010111111101\n" +
                   "1010001010100010100000001010000010000010001\n" +
                   "1011101010111110101111111010111111111010111\n";
    boolean[][] maze = load(input);
    print(maze);
}
private static boolean[][] load(String input) {
    List<boolean[]> maze = new ArrayList<>();
    try (Scanner sc = new Scanner(input)) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            boolean[] row = new boolean[line.length()];
            for (int i = 0; i < row.length; i++) {
                row[i] = (line.charAt(i) != '0');
            }
            maze.add(row);
        }
    }
    return maze.toArray(new boolean[maze.size()][]);
}
private static void print(boolean[][] maze) {
    final String BORDERS = "┌┬│┐" +
                           "├┼│┤" +
                           "──•─" +
                           "└┴│┘";
    for (int y = 0; y < maze.length; y++) {
        for (int x = 0; x < maze[y].length; x++) {
            if (! maze[y][x])
                System.out.print(' ');
            else {
                boolean left  = x > 0 && maze[y][x - 1];
                boolean up    = y > 0 && maze[y - 1][x];
                boolean right = x < maze[y].length - 1 && maze[y][x + 1];
                boolean down  = y < maze.length - 1    && maze[y + 1][x];
                int border = (left  ? 1 : 0)
                           | (right ? 0 : 2)
                           | (up    ? 4 : 0)
                           | (down  ? 0 : 8);
                System.out.print(BORDERS.charAt(border));
            }
        }
        System.out.println();
    }
}