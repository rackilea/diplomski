public class Pet {

//Fields Variables
private String pet_name;
private String owner_name;
private double weight;
private String breed;

//Constructor
public Pet (String name, String o_name, double weight, String breed) {

    //Set the variable values
    this.pet_name = name;
    this.owner_name = o_name;
    this.weight = weight;
    this.breed = breed;
}

//Getter and setter
public String getPet_name() {
    return pet_name;
}

public void setPet_name(String pet_name) {
    this.pet_name = pet_name;
}

public String getOwner_name() {
    return owner_name;
}

public void setOwner_name(String owner_name) {
    this.owner_name = owner_name;
}

public double getWeight() {
    return weight;
}

public void setWeight(double weight) {
    this.weight = weight;
}

public String getBreed() {
    return breed;
}

public void setBreed(String breed) {
    this.breed = breed;
}
}