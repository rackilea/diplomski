@Required
@Enumerated(EnumType.STRING)
public MyEnumType myenum;


public enum MyEnumType {

    ENUMONE ("label one", 1),
    ENUMTWO ("label two", 2);

    String label;
    Int value;

    CastType(String label, Int value) {            
        this.value = value;
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }

    public Int getValue() {
        return this.value;
    }

    public String getLabel()
    {
        return label;
    }

}