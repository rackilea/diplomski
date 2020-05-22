public class Dog {
    String name;
    User owner;

    public Dog(String name) { 
        this.name = name; 
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public User getOwner() { return owner; }

    public void setOwner(User owner) { this.owner = owner; }

    public String ownerAsString() {
        if (getOwner() != null) {
            return getOwner().toString();
        } else {
            return "<No Owner>";
        }
    }

    @Override
    public String toString() {
        return name;
    }
}