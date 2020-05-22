public enum AnimalType {
    Cat, Dog, Parrot;
}

public enum Animals {

    CHLOE(AnimalType.Cat),
    MOLLY(AnimalType.Dog),
    LUNA(AnimalType.Cat),
    TOBY(AnimalType.Dog),
    ZOE(AnimalType.Parrot),
    SNICKERS(AnimalType.Cat);

    private final AnimalType type;

    Animals(AnimalType type) {
        this.type = type;
    }

    public AnimalType get() {
        return type;
    }
}