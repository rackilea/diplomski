enum Fauna {
    enum Type { MAMMAL, BIRD }

    TIGER(Type.MAMMAL), 
    LION(Type.MAMMAL), 
    PEACOCK(Type.BIRD), 
    OWL(Type.BIRD);

    private final Type type;

    Fauna(Type type) { this.type = type; }

}