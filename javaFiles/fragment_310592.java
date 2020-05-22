@Getter
class Bar implements Comparable<Bar> {
    private String name1;
    private String name2;

    @Override
    public int compareTo(Bar o) {
        return name1.compareTo(o.getName1());
    }
}