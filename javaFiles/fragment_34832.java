import java.util.*;

class BreadthFirstSearch {
    public static ArrayList<String> BFS(
        Map<String, String[]> graph, String start, String target
    ) {
        Map<String, String> visited = new HashMap<>();
        visited.put(start, null);
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer(start);

        while (!deque.isEmpty()) {
            String curr = deque.poll();

            if (curr.equals(target)) {
                ArrayList<String> path = new ArrayList<>();
                path.add(curr);

                while (visited.get(curr) != null) {
                    curr = visited.get(curr);
                    path.add(curr);
                }

                Collections.reverse(path);
                return path;
            }

            for (String neighbor : graph.get(curr)) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, curr);
                    deque.offer(neighbor);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Map<String, String[]> myGraph = new HashMap<>();
        myGraph.put(
            "lava", new String[] {"sharks", "piranhas"}
        );
        myGraph.put(
            "sharks", new String[] {"lava", "bees", "lasers"}
        );
        myGraph.put(
            "piranhas", new String[] {"lava", "crocodiles"}
        );
        myGraph.put(
            "bees", new String[] {"sharks"}
        );
        myGraph.put(
            "lasers", new String[] {"sharks", "crocodiles"}
        );
        myGraph.put(
            "crocodiles", new String[] {"piranhas", "lasers"}
        );
        System.out.println(BFS(myGraph, "crocodiles", "bees"));
        System.out.println(BFS(myGraph, "crocodiles", "crocodiles"));
        System.out.println(BFS(myGraph, "crocodiles", "zebras"));
    }
}