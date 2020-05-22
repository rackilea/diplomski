import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortestPath {

    public static List<String> findShortestPath(Map<String, Actor> graph, String start,
        String end) {

        LinkedList<String> bfsList = new LinkedList<>();
        Queue<Actor> queue = new LinkedList<>();
        Map<String, Actor> prev = new HashMap<>();
        Actor current = graph.get(start);

        queue.add(current);
        current.setVisited(true);

        while (!queue.isEmpty()) {

            current = queue.remove();

            if (current.getName().equals(end)) {
                break;
            } else {
                LinkedList<Actor> currentFriends = current.getFriends();
                for (Actor currentFriend : currentFriends) {
                    if (!currentFriend.getVisited()) {
                        queue.add(currentFriend);
                        currentFriend.setVisited(true);
                        prev.put(currentFriend.getName(), current);
                    }
                }
            }
        }

        if (!current.getName().equals(end)) {
            System.out.println("\nThere is no path between " + start + " and " + end);
            return Collections.emptyList();
        }
        for (Actor node = graph.get(end); node != null; node = prev.get(node.getName())) {
            bfsList.add(node.getName());
        }
        Collections.reverse(bfsList);

        return bfsList;

    }

    static class Actor {

        private final String name;
        private final LinkedList<Actor> friends = new LinkedList<>();

        private boolean visited;

        Actor(String name) {
            this.name = name;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        // Would normally be `isVisited`
        public boolean getVisited() {
            return visited;
        }

        public String getName() {
            return name;
        }

        public LinkedList<Actor> getFriends() {
            return friends;
        }

        public void addFriend(Actor actor) {
            this.friends.add(actor);
        }
    }
}