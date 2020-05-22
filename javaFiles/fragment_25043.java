class Person {
    String name = "";

    public String getName() {
        return this.name;
    }

    public void setName(String otherName) {
        this.name = otherName;
    }

    public String toString() {
        return "Person[name=" + this.name + ']';
    }
}