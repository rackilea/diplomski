import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ShortestPathTest {

    Map<String, ShortestPath.Actor> graph = new HashMap<>();

    @Before
    public void setup() {
        newActor("james", "harry", "luke", "john");
        newActor("harry", "luke", "mary");
        newActor("luke", "john", "hepzibah");
        newActor("john", "kate");
        newActor("mary", "hepzibah", "mia");
        newActor("hepzibah", "richard");
        newActor("kate", "martin", "mia");
        newActor("mia", "susan");
        newActor("richard", "rebecca");
        newActor("rebecca", "hannah");
        newActor("michelle");
    }

    private ShortestPath.Actor newActor(String name, String... friends) {
        ShortestPath.Actor actor = graph.computeIfAbsent(name, k -> new ShortestPath.Actor(name));
        for (String friendsName : friends) {
            ShortestPath.Actor friend = newActor(friendsName);
            actor.addFriend(friend);
            friend.addFriend(actor);
        }
        return actor;
    }

    @Test
    public void findShortestPath() {
        List<String> shortestPath = ShortestPath.findShortestPath(graph, "james", "mary");
        assertThat(shortestPath, equalTo(Arrays.asList("james", "harry", "mary")));
    }

    @Test
    public void findLongerShortestPath() {
        List<String> shortestPath = ShortestPath.findShortestPath(graph, "james", "mia");
        assertThat(shortestPath, equalTo(Arrays.asList("james", "harry", "mary", "mia")));
    }

    @Test
    public void findAnotherShortestPath() {
        List<String> shortestPath = ShortestPath.findShortestPath(graph, "harry", "hannah");
        assertThat(shortestPath, equalTo(Arrays.asList("harry", "luke", "hepzibah", "richard", "rebecca", "hannah")));
    }

    @Test
    public void findNoPath() {
        List<String> shortestPath = ShortestPath.findShortestPath(graph, "james", "michelle");
        assertThat(shortestPath, equalTo(Collections.emptyList()));
    }
}