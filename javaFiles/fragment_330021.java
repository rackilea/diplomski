public static void main(String[] args) {
    System.out.println("Maze: ");
    printMaze(maze);

    solveMaze();

    boolean b = recursiveSolve(startX, startY); // Whether or not there is a solution to the maze

    // Put this here!  It will work as expected.
    System.out.println();
    printPath(correctPath);
}