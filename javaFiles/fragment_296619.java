public class Main {


    private static int[][] t1 = {
            {0,1,1,0},
            {0,1,1,0},
            {0,0,0,0},
            {0,0,0,0}
         };

    private static int[][] t2 = {
            {0,0,0,0},
            {0,1,1,1},
            {0,1,0,1},
            {0,1,1,1}
         };

    private static int[][] t3 = {
            {1,1,1,1},
            {1,0,0,1},
            {1,0,0,1},
            {1,1,1,1}
         };

    private static int[][] t4 = {
            {1,1,0,1},
            {0,1,0,1},
            {0,1,0,1},
            {1,1,1,1}
         };

    protected static class Position{
        public int x;
        public int y;

        public Position(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "Position [x=" + x + ", y=" + y + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Position other = (Position) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }

    public static void main(String[] argv) {
        test("t1", t1, new Position(1,0)); //static start position
        test("t2", t2, new Position(1,1)); //static start position
        test("t3", t3, new Position(0,0)); //static start position
        test("t4", t4, new Position(0,0)); //static start position
    }

    public static void test(String name, int[][] arr, Position start){
        System.out.println("Testing case " + name);
        if (testSolution(start, null, new LinkedList<Position>(), arr)){
            System.out.println("Loop Found!");
        }else{
            System.out.println("No Loop.");
        }
    }

    public static boolean testSolution(Position p,Position prior, List<Position> visited, int[][] grid){
        System.out.println("Current: " +p);

        if (visited.contains(p))
            return true;

        visited.add(p);

        for (Position nextP : getNeighbors(p, grid)) {
            if (prior == null || !nextP.equals(prior)){
                if (testSolution(nextP, p, visited, grid)){
                    return true;
                }
            }
        }

        return false;
    }

    public static List<Position> getNeighbors(Position p, int[][] grid){
        //Upper bound 3 hardcoded, could be dynamic.
        List<Position> result = new LinkedList<Position>();
          if (p.x > 0){ //left position
              Position np =new Position(p.x-1,p.y);
              if (grid[np.y][np.x]== 1)
                  result.add(np);
          }
          if (p.x < 3){ //right position
              Position np =new Position(p.x+1,p.y);
              if (grid[np.y][np.x]== 1)
                  result.add(np);
          }
          if (p.y > 0){ //top position
              Position np =new Position(p.x,p.y-1);
              if (grid[np.y][np.x]== 1)
                  result.add(np);
          }
          if (p.y < 3){ //bottom position
              Position np =new Position(p.x,p.y+1);
              if (grid[np.y][np.x]== 1)
                  result.add(np);
          }
        return result;

    }
}