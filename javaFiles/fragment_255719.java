public class ObjectList {

    private List<MyObject> myObjects = new ArrayList<>();

    public ObjectList(Map<String, Object> metrics) {
        metrics.entrySet().forEach(metric -> {
            MyObject myObject = new MyObject(metric.getKey(), metric.getValue());
            myObjects.add(myObject);
        });
    }
}

@Data
public class MyClass {
    private final List<MyObject> objectList;

    public MyClass(List<MyObject> objectList) {
        this.objectList = objectList;
    }
}

@Data
public class MyObject {
    private final String key;
    private final Object value;

    public MyObject(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}