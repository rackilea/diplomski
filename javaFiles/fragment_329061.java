public class StructurePropertyExample {

private static enum StructureProperty {

    SIZE(0.0f), POS_X(0.0f), POS_Y(0.0f), POS_Z(0.0f);

    private float value;

    private StructureProperty(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
};

public static void main(String[] args) {

    float newValue = 1.23f;

    for (StructureProperty property : StructureProperty.values()) {
        switch (property) {
            case SIZE: property.setValue(newValue);
                       break;
            case POS_X : // similar as above
            case POS_Y :
            case POS_Z : 
        }
    }

}