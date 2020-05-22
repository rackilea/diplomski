public static String dukePath(int n, String initPosition) {
    int x = initPosition.charAt(0) - 'a';
    int y = n - (initPosition.charAt(1) - '0');
    boolean grid[][] = new boolean[n][n];
    StringBuilder s = new StringBuilder(initPosition);

    while (true) {
        grid[x][y] = true;

        if (x < (n - 1) && !grid[x + 1][y])
            x++; // Right
        else if (y > 0 && !grid[x][y - 1])
            y--; // Up
        else if (y < (n - 1) && !grid[x][y + 1])
            y++; // Down
        else if (x > 0 && !grid[x - 1][y])
            x--; // Left
        else
            break; // Nowhere left to go!

        s.append("-" + (char)('a' + x) + (char)('0' + n - y));
    }

    if (s.length() > 40) {
        s.replace(20, s.length() - 20, "...");
    }

    return s.toString();
}

public static void main(String args[])
{
    System.out.println(dukePath(3, "b2"));
    System.out.println(dukePath(4, "d4"));
    System.out.println(dukePath(3, "a2"));
    System.out.println(dukePath(4, "d3"));
    System.out.println(dukePath(8, "a8"));
}