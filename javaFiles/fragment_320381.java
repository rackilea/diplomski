Cell[][] grid= new Cell[20][20];
for(int i=0;i<grid.length;i++){
    for(int j=0;j<grid.length;j++){   
       int temp= integer_array[i][j];
       grid[i][j]= new Cell(temp);

       //grid[i][j] will be an object of Cell class and any member of the class 
       //can be called 
    }
}
System.out.println(grid[0][1].data);