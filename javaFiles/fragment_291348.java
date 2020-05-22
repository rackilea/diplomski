// Implementing Serializable allows the object to be passed in intents between activities.
public class Player implements Serializable { 
    private String name;
    private String birthDate;

    // Constructor
    public Player(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    // Below is just Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}