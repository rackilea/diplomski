String[][] grid = new String[int1][int2];
String AB = "_W";
SecureRandom rnd = new SecureRandom();
for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[i].length; j++) {
        grid[i][j] = "" + AB.charAt(rnd.nextInt(AB.length()));
    }
}

for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[i].length; j++) {
        System.out.print(""+grid[i][j]);
    }
    System.out.println();
}

grid[0][rnd.nextInt(int2)] = "S";
grid[int1-1][rnd.nextInt(int2)] = "E";