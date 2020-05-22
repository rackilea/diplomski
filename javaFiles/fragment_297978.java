public class Fruit implements Comparable<Fruit> {
    private String whatYouWantToSortBy;
    ...
    public int compareTo(Fruit other) {
        return whatYouWantToSortBy.compareTo(other.whatYouWantToSortBy);
    }
}