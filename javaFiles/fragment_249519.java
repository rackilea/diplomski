private static void DropYellowDisk(String[][] grid) {

  for (int i=6;i>=0;i--)
    {
      if (grid[i][c] == " ")
      {
        grid[i][c] = "Y";
        return; //break
      }}
}