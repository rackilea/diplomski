public class Person {
    public static class NkComparator implements Comparator<Person>
    {
        public int compare(Person p1, Person p2)
        {
            if (p1 == null || p2 == null) throw new NullPointerException();
            if (p1 == p2) return 0;
            int i = nullSafeCompareTo(p1.firstname, p2.firstname);
            if (i != 0) return i;
            i = nullSafeCompareTo(p1.lastname, p2.lastname);
            if (i != 0) return i;
            return p1.age - p2.age;
        }
        private static int nullSafeCompareTo(String s1, String s2)
        {
            return (s1 == null)
                    ? (s2 == null) ? 0 : -1
                    : (s2 == null) ? 1 : s1.compareTo(s2);
        }
    }
    private String firstname, lastname;
    private int age;
    private long id;
}