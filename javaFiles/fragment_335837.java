public enum MyEnum {
    averageReflection(0),
    maximumLifeSteal(1);
    private int value;
    private MyEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}
...
private double[] attributes = new double[100]; // arbitrary initialization
public double getAttribute(MyEnum attribute) {
    return this.attributes[attribute.getValue()];
}