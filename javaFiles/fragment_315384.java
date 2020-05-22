int width = scan.nextInt();
int height = scan.nextInt();

char c = scan.next().charAt(0);
char [][] grid = new char [width][height]; 

for (int row = 0; row < height - 1; col++) {    
    for (int col = 0; col < width - 1; row++) {
        grid[col][row] = c;  
        System.out.print(grid[col][row]);
    }
    System.out.print("\n");
}