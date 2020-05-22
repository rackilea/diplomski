public interface A {

    @JsonProperty("field_1")
    String getField1();

    @JsonProperty("field_2")
    String getField2();
}

public class B implements A {

    @Override
    @JsonProperty("field_B")
    public String getField1() {
        return "field1";
    }

    @Override
    @JsonIgnore
    public String getField2() {
        return "field2";
    }

}

public class C implements A {

    @Override
    @JsonIgnore
    public String getField1() {
        return "field1";
    }

    @Override
    @JsonProperty("field_C")
    public String getField2() {
        return "field2";
    }

}