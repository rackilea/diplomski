public class People {

    private String name;
    private String city;

    public static final Comparator<People> SORTY_BY_NAME_AND_CITY = (one, two) -> {
        int res = one.name.compareToIgnoreCase(two.name);
        res = res == 0 ? one.city.compareToIgnoreCase(two.city) : res;
        // compare other fields you want
        return res;
    };
}