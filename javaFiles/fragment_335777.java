public static void main(String[] args) {
    List<Integer> l = new LinkedList<Integer>();
    char[][] maze = {{'S', '_', '_'},{'W','W','E'}};
    boolean[][] checked = new boolean[2][3];
    searchPath(maze, 0, 0, l, checked);
    System.out.println(l.toString());
}

public static boolean searchPath(char[][] maze, int x, int y, List<Integer> path, boolean checked[][]) {

    if(checked[y][x]){
        return false;
    }
    checked[y][x] = true;

    if(maze[y][x]=='E') {
        path.add(x);
        path.add(y);
        return true;
    }
    if(maze[y][x]=='_' || maze[y][x] == 'S') {

        int dx = -1;
        int dy = 0;
        if(x +dx >=0 && y + dy >= 0 && x + dx < maze[0].length && y + dy < maze.length && searchPath(maze,x+dx,y+dy,path, checked)) {
            path.add(x);
            path.add(y);
            return true;
        }

        dx = 1;
        dy = 0;
        if(x +dx >=0 && y + dy >= 0 && x + dx < maze[0].length && y + dy < maze.length && searchPath(maze,x+dx,y+dy,path, checked)) {
            path.add(x);
            path.add(y);
            return true;
        }

        dx = 0;
        dy = -1;
        if(x +dx >=0 && y + dy >= 0 && x + dx < maze[0].length && y + dy < maze.length && searchPath(maze,x+dx,y+dy,path, checked)) {
            path.add(x);
            path.add(y);
            return true;
        }

        dx = 0;
        dy = 1;
        if(x +dx >=0 && y + dy >= 0 && x + dx < maze[0].length && y + dy < maze.length && searchPath(maze,x+dx,y+dy,path, checked)) {
            path.add(x);
            path.add(y);
            return true;
        }
    }
    return false;
}