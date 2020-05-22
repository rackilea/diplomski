public interface Checker<T> {
    public boolean check(T obj);
}

public class CatChecker implements Checker<Cat> {
    public boolean check(Cat cat) {
        return (cat.age == 3); // or whatever, implement your comparison here
    }
}

// put this in some class
public static <T> Collection<T> findAll(Collection<T> coll, Checker<T> chk) {
    LinkedList<T> l = new LinkedList<T>();
    for (T obj : coll) {
         if (chk.check(obj))
             l.add(obj);
    }
    return l;
}