private static void menu(Maze maze, Scanner in){
    String option = in.nextLine();
    while(option.toUpperCase() != EXITGAME){
        switch(option.toUpperCase()){
            case PRINTBOARD: printMaze(maze); break;
            case CREATEMAZE: maze = createMaze(in,maze); break;
        }
        System.out.println();
        option = in.nextLine();
    }
}

private static Maze createMaze(Scanner in, Maze maze){
    if(maze == null || !maze.getGameStatus()){
        ... yuor code ...
        maze.createMaze(rawMaze);
    }
    else
        System.out.println("Maze already defined.");

    return maze;
}