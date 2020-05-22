public enum Department {

    CSE("Computer Science Engineering"),
    MEC("Mechanical Engineering")

    private String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}