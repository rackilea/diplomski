public class TestAnimals {
    public static void main(String[] args) {
        Animal lion = new Lion("Geo");
        Animal deer1 = new Deer("D1");
        Animal deer2 = new Deer("D2");

        List<Animal> li = new ArrayList<Animal>();
        li.add(lion);
        li.add(deer1);
        li.add(deer2);
        for (Animal a : li)
            a.accept(new ActionVisitor());         // <-- Accept / visit.
    }
}