public class AbstractConcepts<T extends Concept> {
    private List<T> list = new ArrayList<>();

    public void add(T test) {
        list.add(test);
    }
}

public class Concepts extends AbstractConcepts<Concept> {
    Concepts(String text) {
    }
}

public class Links extends AbstractConcepts<Link> {
}