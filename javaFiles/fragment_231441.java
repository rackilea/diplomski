public class EntityCollection<T extends Entity> implements Iterable<T> {

    protected List<T> entities;

    public EntityCollection() {
        entities = new ArrayList<T>();
    }

    public Iterator<T> iterator() {
        return entities.iterator();
    }

    ... etc

public class HeroCollection extends EntityCollection<Hero> {
    ...
}