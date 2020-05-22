import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class FindNeedleInHaystack {

    String[][] haystack;

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public FindNeedleInHaystack() {
        this.haystack = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.haystack[i][j] = "";
            }
        }
    }

    public void addNeedle(int a_x, int a_y) {
        this.haystack[a_y][a_x] = "needle";
    }

    public boolean hasNeedle() {
        boolean[][] visited = new boolean[10][10];
        return hasNeedleHelper(0, 0);

    }

    private List<Coordinate> neighbors(Coordinate coord, boolean[][] visited) {
        List<Coordinate> neighbors = new ArrayList<>();
        int x = coord.x;
        int y = coord.y;
        if (y + 1 < 10 && !visited[y+1][x]) neighbors.add(new Coordinate(x, y+1));
        if (y - 1 >= 0 && !visited[y-1][x]) neighbors.add(new Coordinate(x, y-1));
        if (x + 1 < 10 && !visited[y][x+1]) neighbors.add(new Coordinate(x + 1, y));
        if (x - 1 >= 0 && !visited[y][x-1]) neighbors.add(new Coordinate(x - 1, y));
        return neighbors;
    }

    private boolean hasNeedleHelper(int x, int y) {
        Stack<Coordinate> fringe = new Stack<>();
        boolean[][] visited = new boolean[10][10];

        fringe.push(new Coordinate(x, y));
        while(!fringe.isEmpty()) {
            Coordinate toVisit = fringe.pop();
            if (this.haystack[toVisit.y][toVisit.x].equals("needle")) {
                return true;
            } else {
                visited[toVisit.y][toVisit.x] = true;
                for(Coordinate coord : this.neighbors(toVisit, visited)) {
                    fringe.push(coord);
                }
            }
        }
        return false;
    }


    public static void main(String...args) {
        FindNeedleInHaystack hasNeedle = new FindNeedleInHaystack();
        hasNeedle.addNeedle(3, 4);
        System.out.println("Has a needle?: " + hasNeedle.hasNeedle());

        FindNeedleInHaystack doesntHaveNeedle = new FindNeedleInHaystack();
        System.out.println("Has a needle?: " + doesntHaveNeedle.hasNeedle());

    }
}