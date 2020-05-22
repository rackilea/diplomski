public Face(int[][] grid){
    int temp[][] = new int[ grid.length ][];
    for( int i = 0; i < temp.length; i++ ) 
      temp[i] = Arrays.copyOf( grid[i], grid[i].length );
    this.grid = temp;
  }