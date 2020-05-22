public static void main(String args[]) {
    Person p1 = new Person(10, 2, 2, 1);
    Person p2 = new Person(10, 2, 2, 2);
    Person p3 = new Person(10, 2, 2, 3);

    List<Person> list = new ArrayList<Person>();
    list.add(p1);
    list.add(p2);
    list.add(p3);

    System.out.println(list.remove(p2)); //true
    System.out.println(list.remove(p2)); //false
    System.out.println(list.remove( new Person(10, 2, 2, 3))); //true
}