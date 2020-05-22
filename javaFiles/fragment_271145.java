public class Article implements Comparable<Article> {
    private String name;
    private int price;

    //Constructors, getters and setters

    @Override
    public int compareTo(Article a) {
        return this.name.compareTo(a.name);
    }
}