import java.util.EnumMap;

public class PlayerCharacter {

    public enum Attribute {
        AGILITY,
        DEXTERITY,
        /* etc ...*/
        VITALITY
    }

    private EnumMap<Attribute, Integer> attributes = new EnumMap<>(Attribute.class);

    public PlayerCharacter() {
        // initialize each attribute with a default value (0 in this example)
        for (Attribute a : Attribute.values()) {
            attributes.put(a, new Integer(0));
        }
    }

    public int getValue(Attribute attribute) {
       return attributes.get(attribute);
    }

    public void levelUp(Attribute attribute, int amount) {
        attributes.put(attribute, attributes.get(attribute) + amount);
    }
}