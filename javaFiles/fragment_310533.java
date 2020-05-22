public static int[][] generateGrid(Scanner in, int gridSize) {
int[][] grid = new int[gridSize][gridSize];

if(in.hasNextLine())in.nextLine();
if(in.hasNextLine())in.nextLine();

while(in.hasNextLine()) {
String[] currentLine = in.nextLine().split("\\s+");
for (int row = 0; row < gridSize; row++) {
    for (int column = 0; column < gridSize; column++) {
         grid[row][column] = Integer.parseInt(currentLine[column]);
    }
}
}
return grid;