public class MyFile implements Comparable<MyFile> {
    private String name;
    private Date creationDate;
    private String author;

    @Override
    public int compareTo(MyFile other) {
        return this.name.compareTo(other.name);
    }
}