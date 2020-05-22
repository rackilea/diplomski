public class Thing {

    @JsonDeserialize(using = MyObjectDeserializer.class)
    private MyObject1 object;

    public MyObject1 getObject() {
        return object;

    public void setObject(MyObject1 object) {
        this.object = object;
    }
}