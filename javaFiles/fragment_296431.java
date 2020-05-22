@JsonAdapter(MyClassAdapter.class)
public class MyClass {
    public Long timestamp;
    public String id;
    public HashMap<String, SomeOtherClass> myMap = new HashMap<>();
}