class Person {
    String firstName;
    String lastName;
    Integer age;

    Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    Person(String firstName, String lastName) {
        this(firstName, lastName, 0);
    }

    Person(String firstName) {
        this(firstName, null, null);
    }
}

Person p1 = new Person("Joe", "Doe", 24);
Person p2 = new Person("Joe", "Doe");
Person p3 = new Person("Joe");