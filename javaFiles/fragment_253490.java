public class Main2 {

    public static void main(String[] args) {

        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 2}
        };
        Maze rat = new Maze();
        rat.solveAndPrintMaze(maze, 0, 0);
    }

}

public class Maze {
    int maze[][];
    int mazeSize;
    int EXIT=2;

    public Maze() {

        mazeSize=4;
        maze = new int[mazeSize][mazeSize];
    }

    // check is its safe to traverse
    public Boolean isSafe(int x, int y, int maze[][]){
        if (x>=0 && x<mazeSize && y>=0 && y<mazeSize && maze[x][y]>=1){
            return true;
        }
        else return false;
    }

    int solmaze[][]= {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};

    boolean solveMaze(int maze[][],int x,int y){

        if(maze[x][y]==EXIT){
            solmaze[x][y]=1;
//          printmaze(solmaze);
            return true;
        }

//      if(isSafe(x, y,maze) && maze[x][y]==1){
//          solmaze[x][y]=1;
//          return true;
//      }

        if(isSafe(x+1, y,maze)==true && solveMaze(maze,x+1,y)==true){// down

            solmaze[x][y]=1;
            return true;
        }

        if(isSafe(x, y+1,maze)==true && solveMaze(maze,x,y+1)==true){//right

            solmaze[x][y]=1;
            return true;
        }

        solmaze[x][y]=0;
        return false;
    }

    void printmaze(int maze[][]){//print maze
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze.length;j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    void solveAndPrintMaze(int maze[][],int x,int y) {
        solveMaze(maze, x, y);
        printmaze(solmaze);
    }
}