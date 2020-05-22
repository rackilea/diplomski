public interface EventType {
    Enum<?> asEnum();
}

enum MyEventTypes implements EventType{
    TYPE_1,TYPE_2,TYPE_3;
    @Override
    public Enum<?> asEnum() {return this;}
}