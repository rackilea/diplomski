import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {
    private List<Object> list = new LinkedList<>();

    public synchronized Object get(int id) {
        return list.get(id);
    }

    public synchronized void add(Object el) {
        list.add(el);
    }

    public synchronized List<Object> getList() {
        return Collections.unmodifiableList(list);
    }
}