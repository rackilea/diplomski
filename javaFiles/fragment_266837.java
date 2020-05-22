public class Friend {
    String name;
    String number;

    public Friend(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 31 * number.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Friend)) {
            return false;
        }
        Friend other = (Friend)obj;
        return other.number.equals(number) && other.name.equals(name);
    }

    @Override
    public String toString() {
        return name + "-" + number;
    }
}

public static void main(String[] args) throws Exception {
    Set<Friend> set1 = new HashSet<Friend>();
    set1.add(new Friend("Karthik", "111"));
    set1.add(new Friend("Mani", "222"));
    set1.add(new Friend("Karthik", "111"));
    set1.add(new Friend("Mani", "444"));
    set1.add(new Friend("Karthik", "111"));

    Set<Friend> set2 = new HashSet<Friend>();
    set2.add(new Friend("Karthik", "111"));
    set2.add(new Friend("Raju", "3333"));

    Set<Friend> set3 = new HashSet<Friend>(set1);
    set3.retainAll(set2);
    set1.removeAll(set3);
    set2.removeAll(set3);

    System.out.println(set1);
    System.out.println(set2);
}