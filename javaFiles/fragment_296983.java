class Dummy implements Comparable<Dummy>{

    String name;

    public int compareTo(Dummy o) {
        return this.name.compareTo(o.name);
    }
}