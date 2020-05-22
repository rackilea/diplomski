public interface Enumerable<E extends Enum<E>> {

    public String getName();

    public E getByName(String name);    
}