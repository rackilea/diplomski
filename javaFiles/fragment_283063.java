class Car {
    String id;
    String name;

    public Car(String id, String name) {
        this.id = id;
        this.name = name;
    }
    // getter & setter
}

LinkedList<Car> list = new LinkedList<Car>();

list.add(new Car("TY12354d", "sfasdf"));
list.add(new Car("TY12354dsaf", "asdffasd"));
list.add(new Car("Pranish", "pranishfilan"));
list.add(new Car("zxs", "asdf"));
list.add(new Car("uv", "vr"));
list.add(new Car("www", "dsf"));
list.add(new Car("dsfgsdf", "sd"));

Collections.sort(list, new Comparator<Car>() {
    public int compare(Car c1, Car c2) {
        return c1.id.compareTo(c2.id);
    }
});