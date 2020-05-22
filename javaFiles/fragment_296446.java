@XmlRootElement(name = "animals")
public class Animals {

    @XmlElement(name = "animal")
    List<Animal> animals;
}

public class Animal {

    @XmlMixed
    List<Object> content;
}