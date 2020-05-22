import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class HashCodeTest {
    private int hashCode = 0;

    @Override public int hashCode() {
        return hashCode ++;
    }

    public static void main(String[] args) {
        Set<HashCodeTest> set = new HashSet<HashCodeTest>();

        set.add(new HashCodeTest());
        System.out.println(set.size());
        for (Iterator<HashCodeTest> iter = set.iterator();
                iter.hasNext();) {
            iter.next();
            iter.remove();
        }
        System.out.println(set.size());
    }
}