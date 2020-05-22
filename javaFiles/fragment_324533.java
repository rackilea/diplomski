public class CollectionModTest {

    public static void main(String[] args) {
        Collection<String> original = new HashSet<String>();
        original.add("1");
        original.add("2");
        original.add("3");
        original.add("4");
        int counter= 5;

        Collection<String> unmodifiable = Collections.unmodifiableCollection(original);

        for (String val: unmodifiable) {
            System.out.println(val);
            original.add(""+counter);
            counter++;
        }

    }

}