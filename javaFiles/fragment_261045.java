public static void main(String[] args)
{
    List<Person> list = new ArrayList<>();
    list.add(new Employee(50));
    list.add(new Customer(10));
    list.add(new Patient(60));
    list.add(new Student(90));
    list.add(new Employee(20));
    list.add(new Customer(40));
    list.add(new Patient(70));
    list.add(new Student(30));

    Collections.sort(list);
    System.out.println(list);
}