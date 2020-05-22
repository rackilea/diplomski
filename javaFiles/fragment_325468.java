import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.ObjectMapper;

public class Example {

    public static void main(String[] args) throws Exception {
        String json = "{\"type\": \"LION\", \"animal\": {\"maneLength\" : 10}}";

        ObjectMapper om = new ObjectMapper();

        Cage cage = om.readValue(json, Cage.class);
        System.out.println(cage.getClass());
        System.out.println(cage.getAnimal());

        System.out.println(((Lion) cage.getAnimal()).getManeLength());
    }
}

class Lion {

    private int maneLength;

    public int getManeLength() {
        return maneLength;
    }

    public void setManeLength(int maneLength) {
        this.maneLength = maneLength;
    }
}

class LionCage extends Cage<Lion> {

    public LionCage() {
        super(AnimalType.LION);
    }
}

class Tiger {
}

class TigerCage extends Cage<Tiger> {

    public TigerCage() {
        super(AnimalType.TIGER);
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = LionCage.class, name = "LION"),
        @JsonSubTypes.Type(value = TigerCage.class, name = "TIGER"), })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class Cage<Animal> {

    public Cage(AnimalType type) {
        this.setType(type);
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    private AnimalType type;
    private Animal animal;
}

enum AnimalType {
    LION, TIGER;
}