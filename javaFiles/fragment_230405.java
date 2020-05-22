public class Model { 
    private final ObjectProperty<Long> number = new SimpleObjectProperty<>(this, "number", 0L); 
    public long getNumber() { return number.get(); }
    public void setNumber(long number) { this.number.set(number); }
    public ObjectProperty<Long> numberProperty() { return number; }
}