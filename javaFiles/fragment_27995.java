import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author newba
 */
public class GraphProblem {

    class Edge {
        int v1;
        int v2;

        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    public GraphProblem () {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {

            int num_exams = cin.nextInt();
            if (num_exams == 0)
                break;
            int k = cin.nextInt();
            Hashtable<Integer,String> exams = new Hashtable<Integer, String>();
            ArrayList<Edge> edges = new ArrayList<Edge>();
            for (int i = 0; i < k; i++) {
                int v1 = cin.nextInt();
                int v2 = cin.nextInt();
                exams.put(v1,"UNKNOWN");
                exams.put(v2,"UNKNOWN");
                //add the edge from A->B and B->A
                edges.add(new Edge(v1, v2));
                edges.add(new Edge(v2, v1));
            }

            boolean possible = true;
            for (Integer key: exams.keySet()){
                if (exams.get(key).equals("UNKNOWN")){
                    if (!colorify(edges, exams,key, "BLACK", "WHITE")){
                        possible = false;
                        break;
                    }
                }
            }

            if (possible)
                System.out.println("POSSIBLE.");
            else
                System.out.println("NOT POSSIBLE.");

        }
    }

    public boolean colorify (ArrayList<Edge> edges,Hashtable<Integer,String> verticesHash,Integer node, String color1, String color2){

        verticesHash.put(node,color1);
        for (Edge edge : edges){
            if (edge.v1 == (int) node) {
                if (verticesHash.get(edge.v2).equals(color1)){
                    return false;
                }
                if (verticesHash.get(edge.v2).equals("UNKNOWN")){
                    colorify(edges, verticesHash, edge.v2, color2, color1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new GraphProblem();
    }
}