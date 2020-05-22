import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.junit.Test;

public class ShortestPathTest {

    Map<String, ShortestPath.Actor> graph = new HashMap<>();

    private ShortestPath.Actor newActor(String name, String... friends) {
        ShortestPath.Actor actor = graph.computeIfAbsent(name, k -> new ShortestPath.Actor(name));
        for(String friendsName : friends) {
            ShortestPath.Actor friend = newActor(friendsName);
            actor.addFriend(friend);
            friend.addFriend(actor);
        }
        return actor;
    }

    @Test
    public void findShortestPath() {
        newActor("james", "harry", "luke", "john");
        newActor("harry", "luke", "mary");

        LinkedList<String> shortestPath = ShortestPath.findShortestPath(graph, "james", "mary");
        assertThat(shortestPath, equalTo(Arrays.asList("james", "harry", "mary")));
    }
}