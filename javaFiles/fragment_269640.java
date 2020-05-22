public class Model {

    private SimpleIntegerProperty value = new SimpleIntegerProperty(this, "value");

    public Model() {
        value.set(5);
    }

    public int getValue(){
        return value.get();
    }

    public void setValue(int value){
        this.value.set(value);
    }

    public IntegerProperty valueProperty(){
        return value;
    }
}