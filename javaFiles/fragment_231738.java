class Fruits {
    public String description;
    public List<Fruit> fruits = new ArrayList<Fruit>();
}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = Fruit.class)
@JsonSubTypes({@JsonSubTypes.Type(value = Fruit.class, name = "fruit"),
        @JsonSubTypes.Type(value = Banana.class, name = "banana")})
class Fruit {
    public String name;
    public int pieces;
}

class Banana extends Fruit {
    public String origin;
}