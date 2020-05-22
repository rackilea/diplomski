public class People {

    private String name;
    private String city;

    public static final Comparator<People> SORT_BY_NAME_ASC = (one, two) -> one.name.compareToIgnoreCase(two.name);
    public static final Comparator<People> SORT_BY_CITY_ASC = (one, two) -> one.city.compareToIgnoreCase(two.city);

}