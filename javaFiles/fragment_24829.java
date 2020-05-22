public class SortByLastName implements Comparator<FullName>{
    public int compare(FullName n1, FullName n2) {
        return n1.getLastName().compareTo(n2.getLastName());
    }
}

TreeSet<FullName> names = new TreeSet<FullName>(new SortByLastName());