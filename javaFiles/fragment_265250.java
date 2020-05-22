class Person {
    private String name;
    // ... some additional fields
    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}