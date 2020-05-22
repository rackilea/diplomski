public class User {
    String name;
    List<Dog> ownedDogs;

    public User(String name) {
        this.name = name;
        ownedDogs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dog> getOwnedDogs() {
        return ownedDogs;
    }

    public void setOwnedDogs(List<Dog> ownedDogs) {
        this.ownedDogs = ownedDogs;
    }

    public void addDog(Dog dog) {
        ownedDogs.add(dog);
        dog.setOwner(this);
    }

    public String ownedDogsAsString() {
        return ownedDogs.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}