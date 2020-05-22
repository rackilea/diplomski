public class IntegerField extends Field {
    private Integer value;
    public IntegerField(Integer value) {
        super();
        this.value = value;
    }

    public Integer toInteger() {
        return value;
    }
}

...

IntegerField a = new IntegerField(8);
Integer b = a.toInteger();