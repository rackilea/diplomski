public enum Animals {

    Cat("Cat", "fluffy animal"), 
    Dog("Dog", "barking animal");

    private final String name;
    private final String description;

    Animals(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}