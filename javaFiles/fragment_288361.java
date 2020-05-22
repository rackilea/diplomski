class People implements Comparable<People> {

    private String name;
    private String city;

    @Override
    public int compareTo(People people) {
        int res = name.compareToIgnoreCase(people.name);
        res = res == 0 ? city.compareToIgnoreCase(people.city) : res;
        // compare other fields you want
        return res;
    }
}