class Grouping {

    public static Person obj = new Person("mark");
    public static Person obj1 = new Person("bob");
    public static Person obj2 = new Person("mark");
    public static Person obj3 = new Person("mark");

    public static List<Person> objects = new ArrayList<>();

    private static Map<String, List<Person>> map = new HashMap<>();

    public static void groupByName(List<Person> objects) {
       map = objects.stream().collect(Collectors.groupingBy(Person::getName));
       // group by the person name
    }


    public static void main(String[]args) {
        objects.add(obj);
        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        groupByName(objects);
        System.out.println(map.get("mark"));
    }
}