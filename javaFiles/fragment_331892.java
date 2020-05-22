String folder = "C:\\Users\\15mik_000\\Desktop\\Text";
String file = "data4-1.txt";
File f = new File(folder, file);
try (Scanner scanner = new Scanner(f)) {
    int rows = scanner.nextInt();
    int cols = scanner.nextInt();
    int[][] maze = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            maze[i][j] = scanner.nextInt();
        }
    }
    System.out.println(Arrays.deepToString(maze));
} catch (IOException e) {
    e.printStackTrace();
}