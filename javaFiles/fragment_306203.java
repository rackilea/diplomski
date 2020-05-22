public static void main(String[] args) {
    String[][] map = new String[][]
             {
                     new String[] { "1","1","1","0","0","0","1","1","1","1" },
                     new String[] { "s","0","0","0","1","1","0","0","0","1" },
                     new String[] { "1","1","0","0","1","0","0","1","0","1" },
                     new String[] { "1","1","1","0","0","0","0","0","0","1" },
                     new String[] { "1","0","1","1","1","0","1","1","0","1" },
                     new String[] { "0","0","0","0","0","0","0","0","0","1" },
                     new String[] { "0","1","1","1","1","1","1","1","1","1" },
                     new String[] { "0","0","0","0","0","0","0","0","0","e" },
             };

    Stack<Cell> path = new Stack<>();
    System.out.println(shortestPath(map, new Cell(1, 0), new Cell(7, 9), path));

    while (!path.isEmpty()) {
        System.out.print(path.pop() + ", ");
    }
}