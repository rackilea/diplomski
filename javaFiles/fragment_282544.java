String[][] grid = new String[int1][int2];
String AB = "_W";
SecureRandom rnd = new SecureRandom();
for (int i = 0; i < grid.length; i++) {
    StringBuilder sb = new StringBuilder(int1);
    for (int j = 0; j < grid[i].length; j++) {
        sb.setLenght(0); // <-- To reset the data
        sb.append(AB.charAt(rnd.nextInt(AB.length())));
        sb.toString(); // You can delete this line which does nothing.
        grid[i][j] = sb.toString();
    }
}

for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[i].length; j++) {
        System.out.print(""+grid[i][j]);
    }
    System.out.println();
}