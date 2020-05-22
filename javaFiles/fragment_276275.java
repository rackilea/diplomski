import java.util.*;

/**
 *
 * @author anon
 */
public class Assignment5 {

    private Stack<Vertex> vertexStack;

    public Assignment5() {
        vertexStack = new Stack<>();
    }

    public static void main(String args[]) {
        int[][] arr = {{1, 0}, {2, 0}, {3, 1}, {3, 2}}; //already sent the code last night during the due date, but changed it slightly so it works a little better
        int rows1 = arr.length;

        int[][] brr = {{1, 0}};
        int rows2 = brr.length;

        int[][] crr = {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {5, 4}};
        int rows3 = crr.length;

        int[][] drr = {{1, 0}, {2, 0}, {3, 1}, {2, 1}, {4, 3}, {5, 3}, {6, 4}, {6, 5}};
        int rows4 = drr.length;

        Assignment5 dfs1 = new Assignment5();
        System.out.println(Arrays.toString(dfs1.findOrder(4, arr)));

        Assignment5 dfs2 = new Assignment5();
        System.out.println(Arrays.toString(dfs2.findOrder(2, brr)));

        Assignment5 dfs3 = new Assignment5();
        System.out.println(Arrays.toString(dfs3.findOrder(6, crr)));

        Assignment5 dfs4 = new Assignment5();
        System.out.println(Arrays.toString(dfs4.findOrder(7, drr)));

    }

    private class Vertex {

        int number;
        boolean visited;
        List<Vertex> neighbours;

        public Vertex(int number) {
            this.number = number;
            this.neighbours = new ArrayList<>();
        }

        public int getNumber() {
            return number;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public void addneighbours(Vertex neighbourVertex) {
            this.neighbours.add(neighbourVertex);
        }

        public List<Vertex> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Vertex> neighbours) {
            this.neighbours = neighbours;
        }

    }

    public void toplogicalSort(Vertex vertex) {
        List<Vertex> neighbours = vertex.getNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            Vertex vertexToGo = neighbours.get(i);
            if (vertexToGo != null && !vertexToGo.visited) {
                toplogicalSort(vertexToGo);
                vertexToGo.setVisited(true);
            }
        }
        vertexStack.push(vertex);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adjacentyMatrix = new int[numCourses][numCourses];

        Vertex[] list = new Vertex[numCourses];

        for (int i = 0; i < numCourses; i++) {
            list[i] = new Vertex(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            list[prerequisites[i][1]].addneighbours(list[prerequisites[i][0]]);
        }

        toplogicalSort(list[0]);

        int[] answer = new int[numCourses];

        int j = 0;
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[j++] = vertexStack.get(i).getNumber();
        }
        return answer;

    }
}