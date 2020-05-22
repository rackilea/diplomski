char[][] grid = new char[R][];
sc.nextLine(); // flush the line containing R and C
for (int i=0;i<R;i++) {
    grid[i] = sc.nextLine().toCharArray();         // char array of size C
    System.out.print(Arrays.toString(grid[i]));
}