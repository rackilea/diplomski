import java.util.Random;
class Maze {
    enum CellType {
        open,wall;
    }
    Maze(int n) {
        this.n=n;
        maze=new CellType[n][n];
        init();
    }
    private void init() {
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                maze[i][j]=CellType.open;
    }
    void randomize(int walls) {
        init();
        Random random=new Random();
        for(int i=0;i<=walls;i++)
            maze[random.nextInt(n)][random.nextInt(n)]=CellType.wall;
    }
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                switch(maze[i][j]) {
                    case open:
                        sb.append(' ');
                        break;
                    case wall:
                        sb.append('|');
                        break;
                }
            sb.append('\n');
        }
        return sb.toString();
    }
    final int n;
    CellType[][] maze;
}
public class Main {
    public static void main(String[] args) {
        Maze maze=new Maze(5);
        System.out.println(maze);
        maze.randomize(4);
        System.out.println(maze);
    }
}