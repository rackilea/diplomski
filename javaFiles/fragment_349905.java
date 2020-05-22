package persistence;

public class ShowRepository implements Repository<Integer, Show> {

    // TODO: You'll need a constructor and a Map for Shows.

    public List<Show> find() {  // the rest for you }
    public Show find(Integer id) {  // the rest for you }
    public List<Show> find(Predicate<Show> filter) {  // the rest for you }
    public void save(Show v) {  // the rest for you }
    public void update(Show v) {  // the rest for you }
    public void delete(Integer id) {  // the rest for you }
    public void delete(Show v) {  // the rest for you }    
}