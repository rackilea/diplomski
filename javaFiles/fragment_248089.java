enum Company {
    APPLE, MICROSOFT
}

class Person {
    private final String name;
    private final Company company;
    public Person(String name, Company company) {
        this.name = name;
        this.company = company;
    }
    public String getName() {
        return this.name;
    }
    public Company getCompany() {
        return this.company;
    }
    @Override
    public String toString() {
        return this.name;
    }
}