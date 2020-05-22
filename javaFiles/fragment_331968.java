public interface Builder {
    public MyObject build();
}

public abstract class AbstractBuilder() {

    private final List<Field> fields = new ArrayList<>();

    protected void addField(String key, String value) {
        fields.add(new Field(key, value));
    }

    @Override
    public MyObject build() {
        MyObject myObject = new MyObject();
        myObject.fields.addAll(this.fields);
        return myObject;
    }
}

public class StoneBuilder extends AbstractBuilder {

    public StoneBuilder withValue(String value) {
        addField("Value", value);
        return this;
    }

    // ...More builder methods...
}

public class RockBuilder extends AbstractBuilder {

    public RockBuilder withAnotherValue(String value) {
        addField("AnotherValue", value);
        return this;
    }

    // ...More builder methods...
}