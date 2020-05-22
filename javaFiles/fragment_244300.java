public interface MyInterface<I extends Serializable, IT extends IdentifiedThing<I>> {
    Collection<IT> find(IT t);
    Collection<IT> findAll();
    IT findById(I id);
    void add(IT t);
    void remove(IT t);
}