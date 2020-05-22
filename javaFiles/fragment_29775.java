package persistence;

public interface ContactDao {
    Collection<Contact> find();
    Contact find(Long id);
    Collection<Contact> find(String lastName);
    Collection<Contact> find(Address address);
    Long save(Contact c);
    void update(Contact c);
    void delete(Contact c);
}