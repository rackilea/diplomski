class Person {

    private String name;
    private int age;

    public Person() {
        //Invoking another constructor
        this("John", 35);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}