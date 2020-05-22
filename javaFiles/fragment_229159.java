class ValueComparator implements Comparator<Integer> {

    Map<Integer, Employee> base;
    public ValueComparator(Map<Integer, Employee> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(Integer a, Integer b) {
        return ((Employee)base.get(a)).compareTo(base.get(b));
    }

}

class Employee implements Comparable {
    public String name;
    public int id;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Object obj) {
        return this.name.compareTo(((Employee)obj).name);
    }

    public String toString() {
        return name;
    }
}