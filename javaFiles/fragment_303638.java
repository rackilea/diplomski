import java.util.*;

public class bfs {

    static class Node {
        Node parent;
        int x;

        Node (int x) {
            this (x, null);
        }

        Node (int x, Node parent) {
            this.parent = parent;
            this.x = x;
        }

        void trace () {
            if (parent == null) {
                System.out.print (x);
            } else {
                parent.trace ();
                System.out.print ("->" + x);
            }
        }
    }

    static void bfs (int start, int goal, int[][] adj) {
        List<Node> list = new ArrayList<> ();

        list.add (new Node (start));

        while (!list.isEmpty ()) {
            Node cur = list.remove (0);

            if (cur.x == goal) {
                cur.trace ();
                break;
            } else {
                for (int i = 0; i < adj[cur.x].length; i++) {
                    if (adj[cur.x][i] == 1) {
                        list.add (new Node (i, cur));
                    }
                }
            }
        }
    }

    public static void main (String[] args) {
        int[][] adjacency_matrix = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {0, 0, 0, 1, 0}
        };
        int start = 0;
        int goal = 4;

        bfs (start, goal, adjacency_matrix);
    }

}