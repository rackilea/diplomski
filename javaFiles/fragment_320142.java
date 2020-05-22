import java.util.*;

 Deque<String> queue = new LinkedList<>(Arrays.asList(new String[] { "1", "2", "3", "4" }));
 Map<String, String> data = new HashMap<>();
 for (int i = 0; i < queue.size(); i++)
    data.put(queue.pop(), queue.pop());